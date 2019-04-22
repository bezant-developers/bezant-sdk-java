package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.response.*;

import java.io.IOException;

public interface BezantApi {

    BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException;

    BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException;

    BezantResponse<ChaincodeInvokeResponse> invokeChaincode(ChaincodeInvokeRequest request) throws IOException;

    BezantResponse<ChaincodeQueryResponse> queryChaincode(ChaincodeQueryRequest request) throws IOException;
}
