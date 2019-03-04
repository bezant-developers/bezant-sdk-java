package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.config.CustomPhaseConfiguration;
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

    public static BezantApi createCustomPhaseApi(String apiKey, String customUrlHost) {
        return createInternal(new CustomPhaseConfiguration(apiKey, customUrlHost));
    }

    private static BezantApi createInternal(Configuration configuration) {
        return new BezantApi(configuration);
    }

}
