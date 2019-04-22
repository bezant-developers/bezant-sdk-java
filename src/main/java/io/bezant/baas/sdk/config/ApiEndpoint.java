package io.bezant.baas.sdk.config;

import okhttp3.HttpUrl;

import java.net.URL;

public class ApiEndpoint {

    private NetworkType networkType;
    private String customUrlHost;

    ApiEndpoint(NetworkType networkType) {
        this.networkType = networkType;
    }

    ApiEndpoint(NetworkType networkType, String customUrlHost) {
        this.networkType = networkType;
        this.customUrlHost = customUrlHost;
    }

    private static final String SCHEMA = "https";
    private static final String MAINNET_HOST = "";
    private static final String TESTNET_HOST = "testnet-apis.bezant.io";

    private HttpUrl.Builder base() {
        return new HttpUrl.Builder()
                .scheme(SCHEMA)
                .host(getHost());
    }

    public URL getChaincodeInvokeUrl(String channelName, String chaincodeName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment(channelName)
                .addPathSegment("chaincodes")
                .addPathSegment(chaincodeName)
                .addPathSegment("invoke")
                .build()
                .url();
    }

    public URL getChaincodeQueryUrl(String channelName, String chaincodeName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment(channelName)
                .addPathSegment("chaincodes")
                .addPathSegment(chaincodeName)
                .addPathSegment("query")
                .build()
                .url();
    }

    public URL getCreateWalletUrl() {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("wallet")
                .build()
                .url();
    }

    public URL getChangeWalletPasswordUrl() {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("wallet")
                .addPathSegment("password")
                .build()
                .url();
    }


    private String getHost() {
        if (networkType == NetworkType.MAINNET) return MAINNET_HOST;
        else if (networkType == NetworkType.TESTNET) return TESTNET_HOST;
        else return customUrlHost;
    }
}
