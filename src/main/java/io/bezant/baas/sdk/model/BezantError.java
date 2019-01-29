package io.bezant.baas.sdk.model;

import lombok.Data;

@Data
public class BezantError {

    private String code;

    private String message;

    public BezantError() {
    }
}
