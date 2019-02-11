package io.bezant.baas.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import io.bezant.baas.sdk.config.ApiEndpoint;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.exception.BezantApiException;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.request.TokenTransferRequest;
import io.bezant.baas.sdk.model.response.*;
import io.bezant.baas.sdk.util.JsonUtils;
import okhttp3.*;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BezantApi {

    private MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client;
    private Configuration configuration;
    private ApiEndpoint endpoint;

    BezantApi(Configuration configuration) {
        this.configuration = configuration;
        this.endpoint = configuration.getApiEndpoint();
        this.client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
    }

    private <T> BezantResponse<T> post(RequestBody requestBody, URL url, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return request(requestBody, url, "POST", typeReference);
    }

    private <T> BezantResponse<T> get(URL url, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return request(null, url, "GET", typeReference);
    }

    private <T> BezantResponse<T> request(RequestBody requestBody, URL url, String method, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        Request.Builder builder = new Request.Builder()
                .header("apikey", configuration.getApiKey());

        if ("POST".equals(method)) {
            builder.post(requestBody);
        } else if ("GET".equals(method)) {
            builder.get();
        }

        Request request = builder.url(url).build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            BezantApiErrorResponse bezantError = (BezantApiErrorResponse) fromJsonWithId(response, new TypeReference<BezantResponse<String>>(){});
            throw new BezantApiException(bezantError);
        }

        return fromJsonWithId(response, typeReference);
    }

    private <T> BezantResponse<T> fromJsonWithId(Response response, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        String requestId = response.header("Request-Id");
        try {
            BezantResponse<T> bezantResponse = JsonUtils.fromJson(response.body().string(), typeReference);
            bezantResponse.setRequestId(requestId);
            return bezantResponse;
        } catch (RuntimeException e) {
            BezantApiErrorResponse bezantError = new BezantApiErrorResponse();
            bezantError.setMessage(response.body().string());
            bezantError.setCode(Integer.toString(response.code()));
            bezantError.setRequestId(requestId);
            throw new BezantApiException(bezantError);
        }
    }

    public BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(Maps.immutableEntry("skey", walletSecretKey)));

        return post(requestBody, endpoint.getCreateWalletUrl(), new TypeReference<BezantResponse<CreateWalletResponse>>() {
        });
    }

    public BezantResponse<TokenTransferResponse> transferToken(TokenTransferRequest request) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));

        return post(requestBody, endpoint.getTokenTransferUrl(request.getTokenName()), new TypeReference<BezantResponse<TokenTransferResponse>>() {
        });
    }

    public BezantResponse<TokenBalanceResponse> getTokenBalance(String tokenName, String address) throws IOException {
        return get(endpoint.getBalanceUrl(tokenName, address), new TypeReference<BezantResponse<TokenBalanceResponse>>() {
        });
    }

    public BezantResponse<ChaincodeInvokeResponse> invokeChaincode(ChaincodeInvokeRequest request) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));

        return post(requestBody, endpoint.getChaincodeInvokeUrl(request.getChaincodeName()), new TypeReference<BezantResponse<ChaincodeInvokeResponse>>() {
        });
    }

    public BezantResponse<ChaincodeQueryResponse> queryChaincode(ChaincodeQueryRequest request) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));

        return post(requestBody, endpoint.getChaincodeQueryUrl(request.getChaincodeName()), new TypeReference<BezantResponse<ChaincodeQueryResponse>>() {
        });
    }
}
