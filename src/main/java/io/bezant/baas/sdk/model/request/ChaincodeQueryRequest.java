package io.bezant.baas.sdk.model.request;

import lombok.Data;

@Data
public class ChaincodeQueryRequest {

    private String channelName;

    private String chaincodeName;

    private String address;

    private String skey;

    private String function;

    private String args;

}
