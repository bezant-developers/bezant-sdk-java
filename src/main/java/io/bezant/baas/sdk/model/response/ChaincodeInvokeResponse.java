package io.bezant.baas.sdk.model.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ChaincodeInvokeResponse extends BezantResponse<ChaincodeInvokeResponse> {

    private String txId;
}
