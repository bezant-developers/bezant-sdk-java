package io.bezant.baas.sdk.model.request.brc20.transfer;

import lombok.Data;

@Data
public class TokenTransferFromArgs {

    private String to;

    private String from;

    private String amount;
}
