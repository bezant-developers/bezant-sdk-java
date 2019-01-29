package io.bezant.baas.sdk.config;

import java.util.Properties;

public abstract class AbstractConfiguration implements Configuration {

    protected String apiKey;

    public AbstractConfiguration(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public boolean isTestNet() {
        return getNetworkType() == NetworkType.TESTNET;
    }

    @Override
    public boolean isMainNet() {
        return getNetworkType() == NetworkType.MAINNET;
    }

    @Override
    public String getApiKey() {
        return apiKey;
    }
}
