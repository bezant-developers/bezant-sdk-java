package io.bezant.baas.sdk.api.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.model.response.ChangeWalletPasswordResponse;
import io.bezant.baas.sdk.model.response.CreateWalletResponse;
import io.bezant.baas.sdk.util.JsonUtils;
import okhttp3.RequestBody;

import java.io.IOException;

public class BezantWalletApi extends AbstractBezantApiBase {

    public BezantWalletApi(Configuration configuration) {
        super(configuration);
    }

    public BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(Maps.immutableEntry("skey", walletSecretKey)));

        return post(requestBody, endpoint.getCreateWalletUrl(), new TypeReference<BezantResponse<CreateWalletResponse>>() {
        });
    }

    public BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonMediaType, JsonUtils.toJson(
                ImmutableMap.of("address", walletAddress,
                        "skey", walletSecretKey,
                        "newSkey", newWalletSecretKey
                )
        ));

        return put(requestBody, endpoint.getChangeWalletPasswordUrl(), new TypeReference<BezantResponse<ChangeWalletPasswordResponse>>() {
        });
    }
}
