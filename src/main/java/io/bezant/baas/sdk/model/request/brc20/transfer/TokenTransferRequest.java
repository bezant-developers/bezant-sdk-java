package io.bezant.baas.sdk.model.request.brc20.transfer;

import io.bezant.baas.sdk.model.request.brc20.base.TokenBase;
import io.bezant.baas.sdk.util.JsonUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
public class TokenTransferRequest extends TokenBase {

    private String fromAddress;

    private String fromSkey;

    private List<TokenTransferArgs> receivers;

    private TokenTransferRequest() {

    }

    private TokenTransferRequest(Builder builder) {
        this.channelName = builder.channelName;
        this.chaincodeName = builder.chaincodeName;
        this.function = FUNCTION_TRANSFER;
        this.fromAddress = builder.fromAddress;
        this.fromSkey = builder.fromSkey;
        this.receivers = builder.receivers;

        Objects.requireNonNull(fromAddress, "fromAddress required");
        Objects.requireNonNull(fromSkey, "fromSKey required");
        Objects.requireNonNull(receivers, "token receiver required");
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public List<String> toArgs() {
        return Collections.singletonList(JsonUtils.toJson(receivers));
    }

    public static final class Builder {
        private String fromAddress;
        private String fromSkey;
        private String chaincodeName;
        private String channelName;
        private List<TokenTransferArgs> receivers = new ArrayList<>();

        private Builder() {
        }

        public TokenTransferRequest build() {
            return new TokenTransferRequest(this);
        }

        public Builder fromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
            return this;
        }

        public Builder fromAddressSecretKey(String fromAddressSecretKey) {
            this.fromSkey = fromAddressSecretKey;
            return this;
        }

        public Builder addReceiver(String toAddress, String amount) {
            TokenTransferArgs tokenTransferArgs = new TokenTransferArgs();
            tokenTransferArgs.setTo(toAddress);
            tokenTransferArgs.setAmount(amount);
            this.receivers.add(tokenTransferArgs);
            return this;
        }

        public Builder receivers(List<TokenTransferArgs> receivers) {
            this.receivers = receivers;
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
