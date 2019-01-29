package io.bezant.baas.sdk.model.response;

import lombok.Data;

@Data
public class BezantApiErrorResponse {

    private String code;

    private String message;

    public BezantApiErrorResponse() {
    }
}
