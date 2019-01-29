package io.bezant.baas.sdk.config;

public interface Configuration {

    boolean isTestNet();

    boolean isMainNet();

    NetworkType getNetworkType();

    ApiEndpoint getApiEndpoint();

    String getApiKey();
}
