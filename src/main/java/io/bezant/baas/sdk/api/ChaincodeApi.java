package io.bezant.baas.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.response.BezantResponse;

import java.io.IOException;

public interface ChaincodeApi {

    <T> BezantResponse<T> invokeChaincode(ChaincodeInvokeRequest request, TypeReference<BezantResponse<T>> typeReference) throws IOException;

    <T> BezantResponse<T> queryChaincode(ChaincodeQueryRequest request, TypeReference<BezantResponse<T>> typeReference) throws IOException;
}
