package io.bezant.baas.sdk.config;

public class TestNetConfiguration extends AbstractConfiguration {

    public TestNetConfiguration(String apiKey) {
        super(apiKey);
    }

    @Override
    public NetworkType getNetworkType() { return NetworkType.TESTNET; }

    @Override
    public ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint(getNetworkType());
    }
}
