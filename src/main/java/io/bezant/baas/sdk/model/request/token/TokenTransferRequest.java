package io.bezant.baas.sdk.model.request.token;

import lombok.Data;

@Data
public class TokenTransferRequest {

    private String channelName;

    private String fromAddress;

    private String fromSkey;

    private String toAddress;

    private String amount;

    private String tokenChaincodeName;
}
