package io.bezant.baas.sdk.api;

import com.fasterxml.jackson.databind.JsonNode;
import io.bezant.baas.sdk.model.request.ChaincodeInvokeRequest;
import io.bezant.baas.sdk.model.request.ChaincodeQueryRequest;
import io.bezant.baas.sdk.model.request.brc20.allowance.TokenAllowanceRequest;
import io.bezant.baas.sdk.model.request.brc20.approve.TokenApproveRequest;
import io.bezant.baas.sdk.model.request.brc20.balance.TokenBalanceRequest;
import io.bezant.baas.sdk.model.request.brc20.supply.TokenTotalSupplyRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferFromRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferRequest;
import io.bezant.baas.sdk.model.response.*;

import java.io.IOException;

public interface BezantApi {

    BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException;

    BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException;

    BezantResponse<JsonNode> invokeChaincode(ChaincodeInvokeRequest request) throws IOException;

    BezantResponse<JsonNode> queryChaincode(ChaincodeQueryRequest request) throws IOException;

    BezantResponse<ChaincodeInvokeResponse> tokenTransfer(TokenTransferRequest tokenTransferRequest) throws IOException;

    BezantResponse<TokenAllowanceResponse> tokenAllowance(TokenAllowanceRequest tokenAllowanceRequest) throws IOException;

    BezantResponse<ChaincodeInvokeResponse> tokenApprove(TokenApproveRequest tokenApproveRequest) throws IOException;

    BezantResponse<ChaincodeInvokeResponse> tokenTransferFrom(TokenTransferFromRequest tokenTransferFromRequest) throws IOException;

    BezantResponse<TokenTotalSupplyResponse> tokenTotalSupply(TokenTotalSupplyRequest tokenTotalSupplyRequest) throws IOException;

    BezantResponse<TokenBalanceResponse> tokenBalance(TokenBalanceRequest tokenBalanceRequest) throws IOException;
}
