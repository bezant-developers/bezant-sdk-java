package io.bezant.baas.sdk.model.request.brc20.supply;

import io.bezant.baas.sdk.model.request.brc20.base.TokenBase;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class TokenTotalSupplyRequest extends TokenBase {

    public String invokerAddress;

    public String invokerSkey;

    private TokenTotalSupplyRequest(Builder builder) {
        this.channelName = builder.channelName;
        this.chaincodeName = builder.chaincodeName;
        this.function = FUNCTION_TOTAL_SUPPLY;
        this.invokerAddress = builder.invokerAddress;
        this.invokerSkey = builder.invokerSkey;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public List<String> toArgs() {
        return Collections.emptyList();
    }

    public static final class Builder {
        private String chaincodeName;
        private String channelName;
        private String invokerAddress;
        private String invokerSkey;

        private Builder() {
        }

        public TokenTotalSupplyRequest build() {
            return new TokenTotalSupplyRequest(this);
        }

        public Builder invokerAddress(String invokerAddress) {
            this.invokerAddress = invokerAddress;
            return this;
        }

        public Builder invokerSkey(String invokerSkey) {
            this.invokerSkey = invokerSkey;
            return this;
        }

        public Builder chaincodeName(String chaincodeName) {
            this.chaincodeName = chaincodeName;
            return this;
        }

        public Builder channelName(String channelName) {
            this.channelName = channelName;
            return this;
        }
    }
}
