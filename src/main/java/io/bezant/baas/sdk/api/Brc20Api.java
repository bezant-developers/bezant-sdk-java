package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.model.request.brc20.allowance.TokenAllowanceRequest;
import io.bezant.baas.sdk.model.request.brc20.approve.TokenApproveRequest;
import io.bezant.baas.sdk.model.request.brc20.balance.TokenBalanceRequest;
import io.bezant.baas.sdk.model.request.brc20.supply.TokenTotalSupplyRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferFromRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferRequest;
import io.bezant.baas.sdk.model.response.*;

import java.io.IOException;

public interface Brc20Api {

    BezantResponse<ChaincodeInvokeResponse> tokenTransfer(TokenTransferRequest tokenTransferRequest) throws IOException;

    BezantResponse<TokenAllowanceResponse> tokenAllowance(TokenAllowanceRequest tokenAllowanceRequest) throws IOException;

    BezantResponse<ChaincodeInvokeResponse> tokenApprove(TokenApproveRequest tokenApproveRequest) throws IOException;

    BezantResponse<ChaincodeInvokeResponse> tokenTransferFrom(TokenTransferFromRequest tokenTransferFromRequest) throws IOException;

    BezantResponse<TokenTotalSupplyResponse> tokenTotalSupply(TokenTotalSupplyRequest tokenTotalSupplyRequest) throws IOException;

    BezantResponse<TokenBalanceResponse> tokenBalance(TokenBalanceRequest tokenBalanceRequest) throws IOException;

}
