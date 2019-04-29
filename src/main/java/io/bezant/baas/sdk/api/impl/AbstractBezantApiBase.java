package io.bezant.baas.sdk.api.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.bezant.baas.sdk.config.ApiEndpoint;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.exception.BezantApiException;
import io.bezant.baas.sdk.model.response.BezantApiErrorResponse;
import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class AbstractBezantApiBase {

    protected MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
    protected ApiEndpoint endpoint;

    private OkHttpClient client;
    private Configuration configuration;

    public AbstractBezantApiBase(Configuration configuration) {
        this.configuration = configuration;
        this.endpoint = configuration.getApiEndpoint();
        this.client = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(15000, TimeUnit.MILLISECONDS)
                .writeTimeout(15000, TimeUnit.MILLISECONDS)
                .build();
    }

    protected <T> BezantResponse<T> post(RequestBody requestBody, URL url, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return request(requestBody, url, "POST", typeReference);
    }

    protected <T> BezantResponse<T> put(RequestBody requestBody, URL url, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return request(requestBody, url, "PUT", typeReference);
    }

    protected <T> BezantResponse<T> get(URL url, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return request(null, url, "GET", typeReference);
    }

    private <T> BezantResponse<T> request(RequestBody requestBody, URL url, String method, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        Request.Builder builder = new Request.Builder()
                .header("apikey", configuration.getApiKey());

        if ("POST".equals(method)) {
            builder.post(requestBody);
        } else if ("PUT".equals(method)) {
            builder.put(requestBody);
        } else if ("GET".equals(method)) {
            builder.get();
        }

        Request request = builder.url(url).build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            BezantResponse<String> bezantResponse = fromJsonWithId(response, new TypeReference<BezantResponse<String>>() {
            });
            BezantApiErrorResponse bezantError = BezantApiErrorResponse.builder().requestId(bezantResponse.getRequestId()).code(bezantResponse.getCode()).message(bezantResponse.getMessage()).build();
            throw new BezantApiException(bezantError);
        }

        return fromJsonWithId(response, typeReference);
    }

    private <T> BezantResponse<T> fromJsonWithId(Response response, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        String requestId = response.header("Request-Id");

        String message = response.body().string();
        int code = response.code();

        log.debug("response : {}", message);

        try {
            BezantResponse<T> bezantResponse = JsonUtils.fromJson(message, typeReference);
            bezantResponse.setRequestId(requestId);
            return bezantResponse;
        } catch (RuntimeException e) {
            BezantApiErrorResponse bezantError = BezantApiErrorResponse.builder()
                    .message(message)
                    .requestId(requestId)
                    .code(Integer.toString(code))
                    .build();
            throw new BezantApiException(bezantError);
        }
    }
}
