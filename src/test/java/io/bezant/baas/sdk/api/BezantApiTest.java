package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.exception.BezantApiException;
import io.bezant.baas.sdk.model.request.token.TokenBalanceRequest;
import io.bezant.baas.sdk.model.request.token.TokenTransferRequest;
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
        api = BezantApiFactory.createTestNetApi("6395c2bd-9bd8-3fb6-8792-4acfd0185874");
    }

    @Test
    public void createWalletApiCall() throws IOException {
        BezantResponse<CreateWalletResponse> response = api.createWallet("bezant");
        log.info(response.toString());
        assertThat(response.getMessage().getEnrollmentID()).isNotBlank();
    }

    @Test
    public void transferTokenApiCall() throws IOException {
        TokenTransferRequest tokenTransferRequest = new TokenTransferRequest();
        tokenTransferRequest.setChannelName("common-channel");
        tokenTransferRequest.setTokenChaincodeName("bezant-token");
        tokenTransferRequest.setFromAddress("bznt0x55D347B50C2a863aDF8E6E23815d82BB240c0311");
        tokenTransferRequest.setToAddress("bznt0x1625A6a0B570f9233066993521C0161aABF0bA3a");
        tokenTransferRequest.setFromSkey("good");
        tokenTransferRequest.setAmount("1");

        BezantResponse<TokenTransferResponse> response = api.transferToken(tokenTransferRequest);
        log.info(response.toString());
        assertThat(response.getMessage().getTxId()).isNotBlank();
    }

    @Test
    public void failed_TransferTokenApiCall_InvalidSkey() throws IOException {
        TokenTransferRequest tokenTransferRequest = new TokenTransferRequest();
        tokenTransferRequest.setChannelName("common-channel");
        tokenTransferRequest.setTokenChaincodeName("bezant-token");
        tokenTransferRequest.setFromAddress("bznt0x55D347B50C2a863aDF8E6E23815d82BB240c0311");
        tokenTransferRequest.setToAddress("bznt0x1625A6a0B570f9233066993521C0161aABF0bA3a");
        tokenTransferRequest.setFromSkey("chequer12!@");
        tokenTransferRequest.setAmount("1");

        boolean thrown = false;
        try {
            api.transferToken(tokenTransferRequest);
        } catch (BezantApiException e) {
            log.info("{}", e);
            if (e.getMessage().trim().equals("Invalid symmetric key.")) thrown = true;
        }

        assertThat(thrown).isTrue();
    }

    @Test
    public void tokenBalanceApiCall() throws IOException {
        TokenBalanceRequest request = new TokenBalanceRequest();
        request.setChannelName("common-channel");
        request.setTokenChaincodeName("bezant-token");
        request.setInvokerAddress("bznt0x55D347B50C2a863aDF8E6E23815d82BB240c0311");
        request.setInvokerSkey("good");
        request.setAddress("bznt0x55D347B50C2a863aDF8E6E23815d82BB240c0311");

        BezantResponse<TokenBalanceResponse> response = api.getTokenBalance(request);
        log.info(response.toString());
        assertThat(response.getMessage().getBalance()).isNotBlank();
    }

    @Test
    public void invokeChaincodeApiCall() throws IOException {
    }

    @Test
    public void queryChaincodeApiCall() throws IOException {
    }

}
