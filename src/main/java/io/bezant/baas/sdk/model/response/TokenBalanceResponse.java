package io.bezant.baas.sdk.model.response;

import lombok.Data;

@Data
public class TokenBalanceResponse extends BezantResponse<TokenBalanceResponse> {

    private String balance;
}
