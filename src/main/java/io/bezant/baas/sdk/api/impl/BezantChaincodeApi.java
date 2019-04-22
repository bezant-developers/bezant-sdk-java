package io.bezant.baas.sdk.api.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.model.response.ChaincodeInvokeResponse;
import io.bezant.baas.sdk.model.response.ChaincodeQueryResponse;
import io.bezant.baas.sdk.util.JsonUtils;
import okhttp3.RequestBody;

import java.io.IOException;

public class BezantChaincodeApi extends AbstractBezantApiBase {

    public BezantChaincodeApi(Configuration configuration) {
        super(configuration);
    }

    public BezantResponse<ChaincodeInvokeResponse> invokeChaincode(ChaincodeInvokeRequest request) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));

        return post(requestBody, endpoint.getChaincodeInvokeUrl(request.getChannelName(), request.getChaincodeName()), new TypeReference<BezantResponse<ChaincodeInvokeResponse>>() {
        });
    }

    public BezantResponse<ChaincodeQueryResponse> queryChaincode(ChaincodeQueryRequest request) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));

        return post(requestBody, endpoint.getChaincodeQueryUrl(request.getChannelName(), request.getChaincodeName()), new TypeReference<BezantResponse<ChaincodeQueryResponse>>() {
        });
    }

}
