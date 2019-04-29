package io.bezant.baas.sdk.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BezantApiErrorResponse {

    private String code;

    private String message;

    private String requestId;

}
