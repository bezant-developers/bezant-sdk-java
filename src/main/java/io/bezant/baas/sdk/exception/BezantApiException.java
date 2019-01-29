package io.bezant.baas.sdk.exception;

import io.bezant.baas.sdk.model.BezantError;

public class BezantApiException extends RuntimeException {

    private String message;

    private String code;

    private BezantError bezantError;

    public BezantApiException(BezantError bezantError) {
        super(bezantError.getMessage());
        this.bezantError = bezantError;
        this.message = bezantError.getMessage();
        this.code = bezantError.getCode();
    }

    public BezantError getBezantError() {
        return bezantError;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
