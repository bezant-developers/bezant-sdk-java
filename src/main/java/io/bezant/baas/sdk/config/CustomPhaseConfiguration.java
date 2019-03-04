package io.bezant.baas.sdk.config;

public class CustomPhaseConfiguration extends AbstractConfiguration {

    private String customUrlHost;

    public CustomPhaseConfiguration(String apiKey, String customUrlHost) {
        super(apiKey);
        this.customUrlHost = customUrlHost;
    }

    @Override
    public NetworkType getNetworkType() { return NetworkType.CUSTOM; }

    @Override
    public ApiEndpoint getApiEndpoint() { return new ApiEndpoint(getNetworkType(), customUrlHost); }
}
