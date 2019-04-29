package io.bezant.baas.sdk.model.request.brc20.transfer;

import lombok.Data;

@Data
public class TokenTransferArgs {

    private String to;

    private String amount;
}
