package io.bezant.baas.sdk.config;

public class MainNetConfiguration extends AbstractConfiguration {

    public MainNetConfiguration(String apiKey) {
        super(apiKey);
    }

    @Override
    public NetworkType getNetworkType() {
        return NetworkType.MAINNET;
    }

    @Override
    public ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint(getNetworkType());
    }
}
