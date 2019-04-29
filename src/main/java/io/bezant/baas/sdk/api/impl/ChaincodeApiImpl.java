package io.bezant.baas.sdk.api.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.bezant.baas.sdk.api.ChaincodeApi;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.util.JsonUtils;
import okhttp3.RequestBody;

import java.io.IOException;

public class ChaincodeApiImpl extends AbstractBezantApiBase implements ChaincodeApi {

    public ChaincodeApiImpl(Configuration configuration) {
        super(configuration);
    }

    public <T> BezantResponse<T> invokeChaincode(ChaincodeInvokeRequest request, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));
        return post(requestBody, endpoint.getChaincodeInvokeUrl(request.getChannelName(), request.getChaincodeName()), typeReference);
    }

    public <T> BezantResponse<T> queryChaincode(ChaincodeQueryRequest request, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(request));

        return post(requestBody, endpoint.getChaincodeQueryUrl(request.getChannelName(), request.getChaincodeName()), typeReference);
    }

}
