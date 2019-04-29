package io.bezant.baas.sdk.model.request.brc20.balance;

import io.bezant.baas.sdk.model.request.brc20.base.TokenBase;
import io.bezant.baas.sdk.util.JsonUtils;
import lombok.Data;

import java.util.*;

@Data
public class TokenBalanceRequest extends TokenBase {

    public String invokerAddress;

    public String invokerSkey;

    private String who;

    private TokenBalanceRequest(Builder builder) {
        this.channelName = builder.channelName;
        this.chaincodeName = builder.chaincodeName;
        this.function = FUNCTION_BAlANCE_OF;
        this.invokerAddress = builder.invokerAddress;
        this.invokerSkey = builder.invokerSkey;
        this.who = builder.who;

        Objects.requireNonNull(invokerAddress, "invokerAddress required");
        Objects.requireNonNull(invokerSkey, "invokerSkey required");
        Objects.requireNonNull(who, "who required");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public List<String> toArgs() {
        Map<String, String> argsMap = new HashMap<>();
        argsMap.put("who", who);
        return Collections.singletonList(JsonUtils.toJson(argsMap));
    }

    public static final class Builder {
        private String chaincodeName;
        private String channelName;
        private String invokerAddress;
        private String invokerSkey;
        private String who;

        private Builder() {
        }

        public TokenBalanceRequest build() {
            return new TokenBalanceRequest(this);
        }

        public Builder invokerAddress(String invokerAddress) {
            this.invokerAddress = invokerAddress;
            return this;
        }

        public Builder invokerSkey(String invokerSkey) {
            this.invokerSkey = invokerSkey;
            return this;
        }

        public Builder who(String who) {
            this.who = who;
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
