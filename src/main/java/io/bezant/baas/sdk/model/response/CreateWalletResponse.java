package io.bezant.baas.sdk.model.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CreateWalletResponse extends BezantResponse<CreateWalletResponse> {

    private String enrollmentID;
}
