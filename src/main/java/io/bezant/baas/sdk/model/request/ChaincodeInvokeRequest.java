package io.bezant.baas.sdk.model.request;

import lombok.Data;

@Data
public class ChaincodeInvokeRequest {

    private String function;

    private String address;

    private String skey;

    private String args;

    private String channelName;

    private String chaincodeName;
}
