package io.bezant.baas.sdk.model.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TokenBalanceResponse extends BezantResponse<TokenBalanceResponse> {

    private String balance;
}
