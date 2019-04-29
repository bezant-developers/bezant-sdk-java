package io.bezant.baas.sdk.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Builder
public class ChaincodeInvokeRequest {

    @NonNull
    private String channelName;

    @NonNull
    private String chaincodeName;

    @NonNull
    private String address;

    @NonNull
    private String skey;

    @NonNull
    private String function;

    @NonNull
    private List<String> args;
}
