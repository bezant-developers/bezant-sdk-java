package io.bezant.baas.sdk;

import io.bezant.baas.sdk.api.WalletApi;
import io.bezant.baas.sdk.api.impl.WalletApiImpl;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.config.MainNetConfiguration;
import io.bezant.baas.sdk.config.TestNetConfiguration;
import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.model.response.ChangeWalletPasswordResponse;
import io.bezant.baas.sdk.model.response.CreateWalletResponse;

import java.io.IOException;

public class BezantWalletApi {

    private WalletApi walletApi;

    private BezantWalletApi(Configuration configuration) {
        walletApi = new WalletApiImpl(configuration);
    }

    public static BezantWalletApi testNet(String apiKey) {
        return new BezantWalletApi(new TestNetConfiguration(apiKey));
    }

    public static BezantWalletApi mainNet(String apiKey) {
        return new BezantWalletApi(new MainNetConfiguration(apiKey));
    }

    public BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException {
        return walletApi.createWallet(walletSecretKey);
    }

    public BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException {
        return walletApi.changeWalletPassword(walletAddress, walletSecretKey, newWalletSecretKey);
    }
}
