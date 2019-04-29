package io.bezant.baas.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.bezant.baas.sdk.api.ChaincodeApi;
import io.bezant.baas.sdk.api.impl.ChaincodeApiImpl;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.config.MainNetConfiguration;
import io.bezant.baas.sdk.config.TestNetConfiguration;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.response.BezantResponse;

import java.io.IOException;

public class BezantChaincodeApi implements ChaincodeApi {

    private ChaincodeApi chaincodeApi;

    private BezantChaincodeApi(Configuration configuration) {
        chaincodeApi = new ChaincodeApiImpl(configuration);
    }

    public static BezantChaincodeApi testNet(String apiKey) {
        return new BezantChaincodeApi(new TestNetConfiguration(apiKey));
    }

    public static BezantChaincodeApi mainNet(String apiKey) {
        return new BezantChaincodeApi(new MainNetConfiguration(apiKey));
    }


    public <T> BezantResponse<T> invokeChaincode(ChaincodeInvokeRequest request, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return chaincodeApi.invokeChaincode(request, typeReference);
    }

    public <T> BezantResponse<T> queryChaincode(ChaincodeQueryRequest request, TypeReference<BezantResponse<T>> typeReference) throws IOException {
        return chaincodeApi.queryChaincode(request, typeReference);
    }

    public BezantResponse<JsonNode> invokeChaincode(ChaincodeInvokeRequest request) throws IOException {
        return chaincodeApi.invokeChaincode(request, new TypeReference<BezantResponse<JsonNode>>() {
        });
    }

    public BezantResponse<JsonNode> queryChaincode(ChaincodeQueryRequest request) throws IOException {
        return chaincodeApi.queryChaincode(request, new TypeReference<BezantResponse<JsonNode>>() {
        });
    }

}
