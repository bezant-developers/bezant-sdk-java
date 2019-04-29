package io.bezant.baas.sdk.model.request.brc20.transfer;

import io.bezant.baas.sdk.model.request.brc20.base.TokenBase;
import io.bezant.baas.sdk.util.JsonUtils;
import lombok.Data;

import java.util.*;

@Data
public class TokenTransferFromRequest extends TokenBase {

    private String invokerAddress;

    private String invokerSkey;

    private String fromAddress;

    private String toAddress;

    private String amount;

    private TokenTransferFromRequest() {

    }

    private TokenTransferFromRequest(Builder builder) {
        this.channelName = builder.channelName;
        this.chaincodeName = builder.chaincodeName;
        this.function = FUNCTION_TRANSFER_FROM;
        this.invokerAddress = builder.invokerAddress;
        this.invokerSkey = builder.invokerSkey;
        this.fromAddress = builder.fromAddress;
        this.toAddress = builder.toAddress;
        this.amount = builder.amount;

        Objects.requireNonNull(invokerAddress, "invokerAddress required");
        Objects.requireNonNull(invokerSkey, "invokerSkey required");
        Objects.requireNonNull(fromAddress, "fromAddress required");
        Objects.requireNonNull(toAddress, "toAddress required");
        Objects.requireNonNull(amount, "amount required");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public List<String> toArgs() {
        Map<String, String> argsMap = new HashMap<>();
        argsMap.put("from", fromAddress);
        argsMap.put("to", toAddress);
        argsMap.put("amount", amount);
        return Collections.singletonList(JsonUtils.toJson(argsMap));
    }

    public static final class Builder {
        private String invokerAddress;
        private String invokerSkey;
        private String fromAddress;
        private String toAddress;
        private String amount;
        private String chaincodeName;
        private String channelName;
        private List<TokenTransferArgs> receivers = new ArrayList<>();

        private Builder() {
        }

        public TokenTransferFromRequest build() {
            return new TokenTransferFromRequest(this);
        }

        public Builder invokerAddress(String invokerAddress) {
            this.invokerAddress = invokerAddress;
            return this;
        }

        public Builder invokerSkey(String invokerSkey) {
            this.invokerSkey = invokerSkey;
            return this;
        }

        public Builder fromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
            return this;
        }

        public Builder toAddress(String toAddress) {
            this.toAddress = toAddress;
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
