package io.bezant.baas.sdk;

import io.bezant.baas.sdk.api.Brc20Api;
import io.bezant.baas.sdk.api.impl.Brc20ApiImpl;
import io.bezant.baas.sdk.config.Configuration;
import io.bezant.baas.sdk.config.MainNetConfiguration;
import io.bezant.baas.sdk.config.TestNetConfiguration;
import io.bezant.baas.sdk.model.request.brc20.allowance.TokenAllowanceRequest;
import io.bezant.baas.sdk.model.request.brc20.approve.TokenApproveRequest;
import io.bezant.baas.sdk.model.request.brc20.balance.TokenBalanceRequest;
import io.bezant.baas.sdk.model.request.brc20.supply.TokenTotalSupplyRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferFromRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferRequest;
import io.bezant.baas.sdk.model.response.*;

import java.io.IOException;

public class BezantBrc20Api {

    private Brc20Api brc20Api;

    private BezantBrc20Api(Configuration configuration) {
        brc20Api = new Brc20ApiImpl(configuration);
    }

    public static BezantBrc20Api testNet(String apiKey) {
        return new BezantBrc20Api(new TestNetConfiguration(apiKey));
    }

    public static BezantBrc20Api mainNet(String apiKey) {
        return new BezantBrc20Api(new MainNetConfiguration(apiKey));
    }

    public BezantResponse<ChaincodeInvokeResponse> tokenTransfer(TokenTransferRequest tokenTransferRequest) throws IOException {
        return brc20Api.tokenTransfer(tokenTransferRequest);
    }

    public BezantResponse<TokenAllowanceResponse> tokenAllowance(TokenAllowanceRequest tokenAllowanceRequest) throws IOException {
        return brc20Api.tokenAllowance(tokenAllowanceRequest);
    }

    public BezantResponse<ChaincodeInvokeResponse> tokenApprove(TokenApproveRequest tokenApproveRequest) throws IOException {
        return brc20Api.tokenApprove(tokenApproveRequest);
    }

    public BezantResponse<ChaincodeInvokeResponse> tokenTransferFrom(TokenTransferFromRequest tokenTransferFromRequest) throws IOException {
        return brc20Api.tokenTransferFrom(tokenTransferFromRequest);
    }

    public BezantResponse<TokenTotalSupplyResponse> tokenTotalSupply(TokenTotalSupplyRequest tokenTotalSupplyRequest) throws IOException {
        return brc20Api.tokenTotalSupply(tokenTotalSupplyRequest);
    }

    public BezantResponse<TokenBalanceResponse> tokenBalance(TokenBalanceRequest tokenBalanceRequest) throws IOException {
        return brc20Api.tokenBalance(tokenBalanceRequest);
    }
}
