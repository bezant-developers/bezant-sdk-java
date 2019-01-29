package io.bezant.baas.sdk.model.response;

import lombok.Data;

@Data
public class TokenTransferResponse extends BezantResponse<TokenTransferResponse> {

    private String txId;
}
