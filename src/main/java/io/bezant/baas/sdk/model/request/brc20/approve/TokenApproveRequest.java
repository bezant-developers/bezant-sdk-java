package io.bezant.baas.sdk.model.request.brc20.approve;

import io.bezant.baas.sdk.model.request.brc20.base.TokenBase;
import io.bezant.baas.sdk.util.JsonUtils;
import lombok.Data;

import java.util.*;

@Data
public class TokenApproveRequest extends TokenBase {

    private String ownerAddress;

    private String ownerSkey;

    private String spenderAddress;

    private String amount;

    private TokenApproveRequest() {
    }

    private TokenApproveRequest(Builder builder) {
        this.channelName = builder.channelName;
        this.chaincodeName = builder.chaincodeName;
        this.function = FUNCTION_APPROVE;
        this.ownerAddress = builder.ownerAddress;
        this.ownerSkey = builder.ownerSkey;
        this.spenderAddress = builder.spenderAddress;
        this.amount = builder.amount;

        Objects.requireNonNull(ownerAddress, "ownerAddress required");
        Objects.requireNonNull(ownerSkey, "ownerSkey required");
        Objects.requireNonNull(spenderAddress, "spenderAddress required");
        Objects.requireNonNull(amount, "amount required");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public List<String> toArgs() {
        Map<String, String> argsMap = new HashMap<>();
        argsMap.put("spender", spenderAddress);
        argsMap.put("amount", amount);
        return Collections.singletonList(JsonUtils.toJson(argsMap));
    }

    public static final class Builder {
        private String ownerAddress;
        private String ownerSkey;
        private String spenderAddress;
        private String amount;
        private String chaincodeName;
        private String channelName;

        private Builder() {
        }

        public TokenApproveRequest build() {
            return new TokenApproveRequest(this);
        }

        public Builder ownerAddress(String ownerAddress) {
            this.ownerAddress = ownerAddress;
            return this;
        }

        public Builder ownerSkey(String ownerSkey) {
            this.ownerSkey = ownerSkey;
            return this;
        }

        public Builder spenderAddress(String spenderAddress) {
            this.spenderAddress = spenderAddress;
            return this;
        }

        public Builder amount(String amount) {
            this.amount = amount;
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
