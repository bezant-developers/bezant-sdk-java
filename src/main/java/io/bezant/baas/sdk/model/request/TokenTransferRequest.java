package io.bezant.baas.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
public class TokenTransferRequest {

    private String fromAddress;

    private String fromSkey;

    private String toAddress;

    private String amount;

    @JsonIgnore
    private String tokenName;
}
