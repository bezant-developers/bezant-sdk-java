package io.bezant.baas.sdk.exception;

import io.bezant.baas.sdk.model.response.BezantApiErrorResponse;

public class BezantApiException extends RuntimeException {

    private String message;

    private String code;

    private BezantApiErrorResponse errorResponse;

    public BezantApiException(BezantApiErrorResponse bezantApiErrorResponse) {
        super(bezantApiErrorResponse.getMessage());
        this.errorResponse = bezantApiErrorResponse;
        this.message = bezantApiErrorResponse.getMessage();
        this.code = bezantApiErrorResponse.getCode();
    }

    public BezantApiErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
