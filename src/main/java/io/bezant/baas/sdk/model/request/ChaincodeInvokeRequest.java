package io.bezant.baas.sdk.model.request;

import lombok.Data;

@Data
public class ChaincodeInvokeRequest {

    private String function;

    private String[] args;

    private String address;

    private String skey;

    private String channelName;

    private String chaincodeName;
}
