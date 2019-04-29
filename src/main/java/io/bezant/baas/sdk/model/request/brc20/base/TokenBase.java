package io.bezant.baas.sdk.model.request.brc20.base;

import lombok.Getter;

public abstract class TokenBase implements ArgsSerializable{

    protected static final String FUNCTION_TRANSFER = "transfer";
    protected static final String FUNCTION_TRANSFER_FROM = "tokenTransferFrom";
    protected static final String FUNCTION_APPROVE = "approve";
    protected static final String FUNCTION_TOTAL_SUPPLY = "totalSupply";
    protected static final String FUNCTION_BAlANCE_OF = "balanceOf";
    protected static final String FUNCTION_ALLOWANCE = "allowance";

    @Getter
    protected String channelName;

    @Getter
    protected String chaincodeName;

    @Getter
    protected String function;
}
