package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.config.MainNetConfiguration;
import io.bezant.baas.sdk.config.TestNetConfiguration;

public class BezantApiFactory {

    private BezantApiFactory() {
    }

    public static BezantApi createMainNetApi(String apiKey) {
        return createInternal(new MainNetConfiguration(apiKey));
    }

    public static BezantApi createTestNetApi(String apiKey) {
        return createInternal(new TestNetConfiguration(apiKey));
    }

    private static BezantApi createInternal(Configuration configuration) {
        return new BezantApi(configuration);
    }
}
