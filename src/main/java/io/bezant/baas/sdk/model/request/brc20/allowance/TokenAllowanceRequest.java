package io.bezant.baas.sdk.model.request.brc20.allowance;

import io.bezant.baas.sdk.model.request.brc20.base.TokenBase;
import io.bezant.baas.sdk.util.JsonUtils;
import lombok.Data;

import java.util.*;

@Data
public class TokenAllowanceRequest extends TokenBase {

    private String requestAddress;

    private String requestSkey;

    private String ownerAddress;

    private String spenderAddress;

    private TokenAllowanceRequest() {

    }

    private TokenAllowanceRequest(Builder builder) {
        this.channelName = builder.channelName;
        this.chaincodeName = builder.chaincodeName;
        this.function = FUNCTION_ALLOWANCE;
        this.requestAddress = builder.requestAddress;
        this.requestSkey = builder.requestSkey;
        this.ownerAddress = builder.ownerAddress;
        this.spenderAddress = builder.spenderAddress;

        Objects.requireNonNull(requestAddress, "requestAddress required");
        Objects.requireNonNull(requestSkey, "requestSKey required");
        Objects.requireNonNull(ownerAddress, "ownerAddress required");
        Objects.requireNonNull(spenderAddress, "spenderAddress required");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public List<String> toArgs() {
        Map<String, String> argsMap = new HashMap<>();
        argsMap.put("owner", ownerAddress);
        argsMap.put("spender", spenderAddress);
        return Collections.singletonList(JsonUtils.toJson(argsMap));
    }

    public static final class Builder {
        private String requestAddress;
        private String requestSkey;
        private String ownerAddress;
        private String spenderAddress;
        private String chaincodeName;
        private String channelName;

        private Builder() {
        }

        public TokenAllowanceRequest build() {
            return new TokenAllowanceRequest(this);
        }

        public Builder requestAddress(String requestAddress) {
            this.requestAddress = requestAddress;
            return this;
        }

        public Builder requestSkey(String requestSkey) {
            this.requestSkey = requestSkey;
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

        public Builder ownerAddress(String ownerAddress) {
            this.ownerAddress = ownerAddress;
            return this;
        }

        public Builder spenderAddress(String spenderAddress) {
            this.spenderAddress = spenderAddress;
            return this;
        }
    }
}
