package io.bezant.baas.sdk.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class BezantResponse<T> {

    protected String code;

    protected T message;

    @Setter
    protected String requestId;
}
