package io.bezant.baas.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ChaincodeInvokeRequest {

    private String function;

    private String[] args;

    private String address;

    private String skey;

    @JsonIgnore
    private String chaincodeName;
}
