package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.api.impl.BezantChaincodeApi;
import io.bezant.baas.sdk.api.impl.BezantWalletApi;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.response.*;

import java.io.IOException;

public class BezantApiImpl implements BezantApi {

    private BezantWalletApi walletApi;

    private BezantChaincodeApi chaincodeApi;

    public BezantApiImpl(Configuration configuration) {
        walletApi = new BezantWalletApi(configuration);
        chaincodeApi = new BezantChaincodeApi(configuration);
    }

    @Override
    public BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException {
        return walletApi.createWallet(walletSecretKey);
    }

    @Override
    public BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException {
        return walletApi.changeWalletPassword(walletAddress, walletSecretKey, newWalletSecretKey);
    }

    @Override
    public BezantResponse<ChaincodeInvokeResponse> invokeChaincode(ChaincodeInvokeRequest request) throws IOException {
        return chaincodeApi.invokeChaincode(request);
    }

    @Override
    public BezantResponse<ChaincodeQueryResponse> queryChaincode(ChaincodeQueryRequest request) throws IOException {
        return chaincodeApi.queryChaincode(request);
    }
}
