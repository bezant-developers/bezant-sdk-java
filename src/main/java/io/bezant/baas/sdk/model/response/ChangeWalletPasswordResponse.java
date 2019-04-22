package io.bezant.baas.sdk.model.response;

import lombok.Data;

@Data
public class ChangeWalletPasswordResponse extends BezantResponse<ChangeWalletPasswordResponse> {

    private String enrollmentID;
}
