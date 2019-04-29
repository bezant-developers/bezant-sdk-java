package io.bezant.baas.sdk.api;

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

    private BezantApi api;

    @Before
    public void setup() {
        api = BezantApiFactory.createTestNetApi("efbe0d20-d0ab-3e94-b8e8-6085373745f1");
    }

    @Test
    public void createWalletApiCall() throws IOException {
        BezantResponse<CreateWalletResponse> response = api.createWallet("bezant");
        log.info(response.toString());
        assertThat(response.getMessage().getEnrollmentID()).isNotBlank();
    }

    @Test
    public void changeWalletPasswordApiCall() throws IOException {
        BezantResponse<ChangeWalletPasswordResponse> response = api.changeWalletPassword("bznt0xF1Ac69817Bb3C1e6E70606F9Ce48Fd9eF7693d07", "bezant3", "bezant");
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
                .addReceiver("bznt0x313902d26E344D4975A0d1d152d01fB489f0cf16", "1")
                .addReceiver("bznt0xCB81F4A2068e3e09EE6b0aBd11efC52EE5543AD1", "2")
                .build();

        BezantResponse<ChaincodeInvokeResponse> response = api.tokenTransfer(tokenTransferRequest);

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

        BezantResponse<ChaincodeInvokeResponse> response = api.tokenApprove(tokenApproveRequest);

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

        BezantResponse<TokenAllowanceResponse> response = api.tokenAllowance(tokenAllowanceRequest);

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

        BezantResponse<ChaincodeInvokeResponse> response = api.tokenTransferFrom(tokenTransferFromRequest);

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

        BezantResponse<TokenTotalSupplyResponse> response = api.tokenTotalSupply(tokenTotalSupplyRequest);

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

        BezantResponse<TokenBalanceResponse> response = api.tokenBalance(tokenBalanceRequest);

        System.out.println(response);
    }

}
