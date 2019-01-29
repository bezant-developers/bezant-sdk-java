package io.bezant.baas.sdk.model.response;

import lombok.Data;

@Data
public class BezantResponse<T> {

    private String code;

    private T message;
}
