package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.exception.BezantApiException;
import io.bezant.baas.sdk.model.request.TokenTransferRequest;
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
        tokenTransferRequest.setTokenName("chequer");
        tokenTransferRequest.setFromAddress("bznt0x939F0e76675424b603b61B1472A5C99301414197");
        tokenTransferRequest.setToAddress("bznt0x1E50408Cf2972A1DeEe74A00Be07A156cdFc5362");
        tokenTransferRequest.setFromSkey("chequer12!@");
        tokenTransferRequest.setAmount("1");

        BezantResponse<TokenTransferResponse> response = api.transferToken(tokenTransferRequest);
        log.info(response.toString());
        assertThat(response.getMessage().getTxId()).isNotBlank();
    }

    @Test
    public void failed_TransferTokenApiCall_InvalidSkey() throws IOException {
        TokenTransferRequest tokenTransferRequest = new TokenTransferRequest();
        tokenTransferRequest.setTokenName("chequer");
        tokenTransferRequest.setFromAddress("bznt0x939F0e76675424b603b61B1472A5C99301414197");
        tokenTransferRequest.setToAddress("bznt0x1E50408Cf2972A1DeEe74A00Be07A156cdFc5362");
        tokenTransferRequest.setFromSkey("invalidSkey");
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
        BezantResponse<TokenBalanceResponse> response = api.getTokenBalance("chequer", "bznt0x939F0e76675424b603b61B1472A5C99301414197");
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
