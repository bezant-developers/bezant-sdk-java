package io.bezant.baas.sdk.model.request.token;

import lombok.Data;

@Data
public class TokenBalanceRequest {

    public String channelName;

    public String tokenChaincodeName;

    public String invokerAddress;

    public String invokerSkey;

    public String address;

}
