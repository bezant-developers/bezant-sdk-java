package io.bezant.baas.sdk.model.response;

import lombok.Data;

@Data
public class CreateWalletResponse extends BezantResponse<CreateWalletResponse> {

    private String enrollmentID;
}
