package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.BezantBrc20Api;
import io.bezant.baas.sdk.BezantChaincodeApi;
import io.bezant.baas.sdk.BezantWalletApi;
import io.bezant.baas.sdk.model.request.brc20.allowance.TokenAllowanceRequest;
import io.bezant.baas.sdk.model.request.brc20.approve.TokenApproveRequest;
import io.bezant.baas.sdk.model.request.brc20.balance.TokenBalanceRequest;
import io.bezant.baas.sdk.model.request.brc20.supply.TokenTotalSupplyRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferFromRequest;
import io.bezant.baas.sdk.model.request.brc20.transfer.TokenTransferRequest;
import io.bezant.baas.sdk.model.response.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class BezantApiTest {

    private BezantWalletApi walletApi;
    private BezantChaincodeApi chaincodeApi;
    private BezantBrc20Api brc20Api;

    @Before
    public void setup() {
        walletApi = BezantWalletApi.testNet("efbe0d20-d0ab-3e94-b8e8-6085373745f1");
        chaincodeApi = BezantChaincodeApi.testNet("efbe0d20-d0ab-3e94-b8e8-6085373745f1");
        brc20Api = BezantBrc20Api.testNet("efbe0d20-d0ab-3e94-b8e8-6085373745f1");
    }

    @Test
    public void createWalletApiCall() throws IOException {
        BezantResponse<CreateWalletResponse> response = walletApi.createWallet("bezant");
        log.info(response.toString());
        assertThat(response.getMessage().getEnrollmentID()).isNotBlank();
    }

    @Test
    public void changeWalletPasswordApiCall() throws IOException {
        BezantResponse<ChangeWalletPasswordResponse> response = walletApi.changeWalletPassword("bznt0xF1Ac69817Bb3C1e6E70606F9Ce48Fd9eF7693d07", "bezant3", "bezant");
        log.info(response.toString());
        assertThat(response.getMessage().getEnrollmentID()).isNotBlank();
    }


    @Test
    public void brc20TransferApiCall() throws IOException {
        TokenTransferRequest tokenTransferRequest = TokenTransferRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .fromAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .fromAddressSecretKey("1234")
                .addReceiver("bznt0x313902d26E344D4975A0d1d152d01fB489f0cf16", "100")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1", "200")
                .build();

        BezantResponse<ChaincodeInvokeResponse> response = brc20Api.tokenTransfer(tokenTransferRequest);

        System.out.println(response);

    }

    @Test
    public void brc20ApproveApiCall() throws IOException {
        TokenApproveRequest tokenApproveRequest = TokenApproveRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .ownerAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .ownerSkey("1234")
                .spenderAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .amount("10")
                .build();

        BezantResponse<ChaincodeInvokeResponse> response = brc20Api.tokenApprove(tokenApproveRequest);

        System.out.println(response);
    }

    @Test
    public void brc20AllowanceApiCall() throws IOException {
        TokenAllowanceRequest tokenAllowanceRequest = TokenAllowanceRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .requestAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .requestSkey("1234")
                .ownerAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .spenderAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .build();

        BezantResponse<TokenAllowanceResponse> response = brc20Api.tokenAllowance(tokenAllowanceRequest);

        System.out.println(response);
    }

    @Test
    public void brc20TransferFromApiCall() throws IOException {
        TokenTransferFromRequest tokenTransferFromRequest = TokenTransferFromRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .invokerAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .invokerSkey("1234")
                .fromAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .toAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .amount("1")
                .build();

        BezantResponse<ChaincodeInvokeResponse> response = brc20Api.tokenTransferFrom(tokenTransferFromRequest);

        System.out.println(response);
    }

    @Test
    public void brc20TotalSupplyApiCall() throws IOException {
        TokenTotalSupplyRequest tokenTotalSupplyRequest = TokenTotalSupplyRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .invokerAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .invokerSkey("1234")
                .build();

        BezantResponse<TokenTotalSupplyResponse> response = brc20Api.tokenTotalSupply(tokenTotalSupplyRequest);

        System.out.println(response);
    }

    @Test
    public void brc20BalanceOfApiCall() throws IOException {
        TokenBalanceRequest tokenBalanceRequest = TokenBalanceRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .invokerAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .invokerSkey("1234")
                .who("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .build();

        BezantResponse<TokenBalanceResponse> response = brc20Api.tokenBalance(tokenBalanceRequest);

        System.out.println(response);
    }

    @Test
    public void airdrop() throws IOException {
        TokenTransferRequest tokenTransferRequest = TokenTransferRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .fromAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .fromAddressSecretKey("1234")
                .addReceiver("bznt0x313902d26E344D4975A0d1d152d01fB489f0cf16", "1")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD5", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD3", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aEd11efC52EE5543AD2", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aSd11efC52EE5543AD1", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aCd11efC52EE5543AD5", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aCd11efC52EE5543AD7", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD4", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1", "2")
                .addReceiver("bznt0xCB81F4B2068e3e09EE6b0aBd11efC52EE5543AD3", "2")
                .addReceiver("bznt0xCB81F4C2068e3e09EE6b0aBd11efC52EE5543AD1", "2")
                .addReceiver("bznt0xCB81F4F2068e3e09EE6b0aBd11efC52EE5543AD1", "2")
                .addReceiver("bznt0xCB81F4E2068e3e09EE6b0aBd11efC52EE5543AD5", "2")
                .addReceiver("bznt0xCB81F4Q2068e3e09EE6b0aBd11efC52EE5543AD3", "2")
                .addReceiver("bznt0xCB81F4F2068e3e09EE6b0aBd11efC52EE5543AD7", "2")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD5", "2")
                .build();

        BezantResponse<ChaincodeInvokeResponse> response = brc20Api.tokenTransfer(tokenTransferRequest);
    }

    @Test
    public void escrow() throws IOException {
        // 구매자가 판매자에게 10 만큼을 예치한다.
        TokenApproveRequest tokenApproveRequest = TokenApproveRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .ownerAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .ownerSkey("1234")
                .spenderAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .amount("10")
                .build();

        BezantResponse<ChaincodeInvokeResponse> approveResponse = brc20Api.tokenApprove(tokenApproveRequest);


        // 판매자는 구매자가 10만큼 토큰을 예치했는지 확인한다.
        TokenAllowanceRequest tokenAllowanceRequest = TokenAllowanceRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .requestAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .requestSkey("1234")
                .ownerAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .spenderAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .build();

        BezantResponse<TokenAllowanceResponse> allowanceResponse = brc20Api.tokenAllowance(tokenAllowanceRequest);


        // 판매자는 구매자에게 물건을 배송한다.


        // 배송이 끝났다면 중계플랫폼에서 구매자 -> 판매자로 토큰을 전송한다.
        // 이떄 수수료를 제하고 9.5 만큼만 보낼수도 있다.
        TokenTransferFromRequest tokenTransferFromRequest = TokenTransferFromRequest.builder()
                .channelName("bezant-channel")
                .chaincodeName("chequerthree")
                .invokerAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .invokerSkey("1234")
                .fromAddress("bznt0x144E3049E78e053902F0d8165FbA2608DD0993DC")
                .toAddress("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1")
                .amount("9.5")
                .build();

        BezantResponse<ChaincodeInvokeResponse> response = brc20Api.tokenTransferFrom(tokenTransferFromRequest);

        System.out.println(response);
    }
}
