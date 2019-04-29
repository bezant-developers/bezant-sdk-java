package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.model.response.ChangeWalletPasswordResponse;
import io.bezant.baas.sdk.model.response.CreateWalletResponse;

import java.io.IOException;

public interface WalletApi {

    BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException;

    BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException;
}
