package io.bezant.baas.sdk.model.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ChangeWalletPasswordResponse extends BezantResponse<ChangeWalletPasswordResponse> {

    private String enrollmentID;
}
