package io.bezant.baas.sdk.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.bezant.baas.sdk.api.impl.BezantChaincodeApi;
import io.bezant.baas.sdk.api.impl.BezantWalletApi;
import io.bezant.baas.sdk.config.Configuration;
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

public class BezantApiImpl implements BezantApi {

    private BezantWalletApi walletApi;

    private BezantChaincodeApi chaincodeApi;

    public BezantApiImpl(Configuration configuration) {
        walletApi = new BezantWalletApi(configuration);
        chaincodeApi = new BezantChaincodeApi(configuration);
    }

    @Override
    public BezantResponse<CreateWalletResponse> createWallet(String walletSecretKey) throws IOException {
        return walletApi.createWallet(walletSecretKey);
    }

    @Override
    public BezantResponse<ChangeWalletPasswordResponse> changeWalletPassword(String walletAddress, String walletSecretKey, String newWalletSecretKey) throws IOException {
        return walletApi.changeWalletPassword(walletAddress, walletSecretKey, newWalletSecretKey);
    }

    @Override
    public BezantResponse<JsonNode> invokeChaincode(ChaincodeInvokeRequest request) throws IOException {
        return chaincodeApi.invokeChaincode(request, new TypeReference<BezantResponse<JsonNode>>() {
        });
    }

    @Override
    public BezantResponse<JsonNode> queryChaincode(ChaincodeQueryRequest request) throws IOException {
        return chaincodeApi.queryChaincode(request, new TypeReference<BezantResponse<JsonNode>>() {
        });
    }

    @Override
    public BezantResponse<ChaincodeInvokeResponse> tokenTransfer(TokenTransferRequest tokenTransferRequest) throws IOException {
        ChaincodeInvokeRequest chaincodeInvokeRequest = ChaincodeInvokeRequest.builder()
                .chaincodeName(tokenTransferRequest.getChaincodeName())
                .channelName(tokenTransferRequest.getChannelName())
                .function(tokenTransferRequest.getFunction())
                .skey(tokenTransferRequest.getFromSkey())
                .address(tokenTransferRequest.getFromAddress())
                .args(tokenTransferRequest.toArgs())
                .build();

        return chaincodeApi.invokeChaincode(chaincodeInvokeRequest, new TypeReference<BezantResponse<ChaincodeInvokeResponse>>() {
        });
    }

    @Override
    public BezantResponse<TokenAllowanceResponse> tokenAllowance(TokenAllowanceRequest tokenAllowanceRequest) throws IOException {
        ChaincodeQueryRequest chaincodeQueryRequest = ChaincodeQueryRequest.builder()
                .chaincodeName(tokenAllowanceRequest.getChaincodeName())
                .channelName(tokenAllowanceRequest.getChannelName())
                .function(tokenAllowanceRequest.getFunction())
                .skey(tokenAllowanceRequest.getRequestSkey())
                .address(tokenAllowanceRequest.getRequestSkey())
                .args(tokenAllowanceRequest.toArgs())
                .build();

        return chaincodeApi.queryChaincode(chaincodeQueryRequest, new TypeReference<BezantResponse<TokenAllowanceResponse>>() {
        });
    }

    @Override
    public BezantResponse<ChaincodeInvokeResponse> tokenApprove(TokenApproveRequest tokenApproveRequest) throws IOException {
        ChaincodeInvokeRequest chaincodeInvokeRequest = ChaincodeInvokeRequest.builder()
                .chaincodeName(tokenApproveRequest.getChaincodeName())
                .channelName(tokenApproveRequest.getChannelName())
                .function(tokenApproveRequest.getFunction())
                .skey(tokenApproveRequest.getOwnerSkey())
                .address(tokenApproveRequest.getOwnerAddress())
                .args(tokenApproveRequest.toArgs())
                .build();

        return chaincodeApi.invokeChaincode(chaincodeInvokeRequest, new TypeReference<BezantResponse<ChaincodeInvokeResponse>>() {
        });
    }

    @Override
    public BezantResponse<ChaincodeInvokeResponse> tokenTransferFrom(TokenTransferFromRequest tokenTransferFromRequest) throws IOException {
        ChaincodeInvokeRequest chaincodeInvokeRequest = ChaincodeInvokeRequest.builder()
                .chaincodeName(tokenTransferFromRequest.getChaincodeName())
                .channelName(tokenTransferFromRequest.getChannelName())
                .function(tokenTransferFromRequest.getFunction())
                .skey(tokenTransferFromRequest.getInvokerSkey())
                .address(tokenTransferFromRequest.getInvokerAddress())
                .args(tokenTransferFromRequest.toArgs())
                .build();

        return chaincodeApi.invokeChaincode(chaincodeInvokeRequest, new TypeReference<BezantResponse<ChaincodeInvokeResponse>>() {
        });
    }

    @Override
    public BezantResponse<TokenTotalSupplyResponse> tokenTotalSupply(TokenTotalSupplyRequest tokenTotalSupplyRequest) throws IOException {
        ChaincodeQueryRequest chaincodeQueryRequest = ChaincodeQueryRequest.builder()
                .chaincodeName(tokenTotalSupplyRequest.getChaincodeName())
                .channelName(tokenTotalSupplyRequest.getChannelName())
                .function(tokenTotalSupplyRequest.getFunction())
                .skey(tokenTotalSupplyRequest.getInvokerSkey())
                .address(tokenTotalSupplyRequest.getInvokerAddress())
                .args(tokenTotalSupplyRequest.toArgs())
                .build();

        return chaincodeApi.queryChaincode(chaincodeQueryRequest, new TypeReference<BezantResponse<TokenTotalSupplyResponse>>() {
        });
    }

    @Override
    public BezantResponse<TokenBalanceResponse> tokenBalance(TokenBalanceRequest tokenBalanceRequest) throws IOException {
        ChaincodeQueryRequest chaincodeQueryRequest = ChaincodeQueryRequest.builder()
                .chaincodeName(tokenBalanceRequest.getChaincodeName())
                .channelName(tokenBalanceRequest.getChannelName())
                .function(tokenBalanceRequest.getFunction())
                .skey(tokenBalanceRequest.getInvokerSkey())
                .address(tokenBalanceRequest.getInvokerAddress())
                .args(tokenBalanceRequest.toArgs())
                .build();

        return chaincodeApi.queryChaincode(chaincodeQueryRequest, new TypeReference<BezantResponse<TokenBalanceResponse>>() {
        });
    }
}
