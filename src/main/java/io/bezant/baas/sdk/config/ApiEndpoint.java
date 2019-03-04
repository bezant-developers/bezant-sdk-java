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

    public URL getNewCreateWalletUrl() {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("tokens")
                .addPathSegment("it_will_be_removed")
                .addPathSegment("wallet")
                .build()
                .url();
    }

    public URL getNewTokenTransferUrl(String tokenName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("tokens")
                .addPathSegment(tokenName)
                .addPathSegment("transfer")
                .build()
                .url();
    }

    public URL getNewBalanceUrl(String channelName, String chaincodeName) {
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

    public URL getNewChaincodeInvokeUrl(String channelName, String chaincodeName) {
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

    public URL getNewChaincodeQueryUrl(String channelName, String chaincodeName) {
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

    public URL getCreateWalletUrl(String channelName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment(channelName)
                .addPathSegment("wallet")
                .build()
                .url();
    }

    public URL getTokenTransferUrl(String tokenName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("tokens")
                .addPathSegment(tokenName)
                .addPathSegment("transfer")
                .build()
                .url();
    }

    public URL getBalanceUrl(String tokenName, String address) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("tokens")
                .addPathSegment(tokenName)
                .addPathSegment("balance")
                .addQueryParameter("address", address)
                .build()
                .url();
    }

    public URL getChaincodeInvokeUrl(String chainName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("chaincodes")
                .addPathSegment(chainName)
                .addPathSegment("invoke")
                .build()
                .url();
    }

    public URL getChaincodeQueryUrl(String chainName) {
        return base()
                .addPathSegment("blockchain")
                .addPathSegment("v1")
                .addPathSegment("chaincodes")
                .addPathSegment(chainName)
                .addPathSegment("query")
                .build()
                .url();
    }

    private String getHost() {
        if (networkType == NetworkType.MAINNET) return MAINNET_HOST;
        else if (networkType == NetworkType.TESTNET) return TESTNET_HOST;
        else return customUrlHost;
    }
}
