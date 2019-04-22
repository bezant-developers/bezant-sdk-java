package io.bezant.baas.sdk.api;

import io.bezant.baas.sdk.model.response.BezantResponse;
import io.bezant.baas.sdk.model.response.ChangeWalletPasswordResponse;
import io.bezant.baas.sdk.model.response.CreateWalletResponse;
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
        BezantResponse<ChangeWalletPasswordResponse> response = api.changeWalletPassword("bznt0xF1Ac69817Bb3C1e6E70606F9Ce48Fd9eF7693d07", "bezant2", "bezant3");
        log.info(response.toString());
        assertThat(response.getMessage().getEnrollmentID()).isNotBlank();
    }


    @Test
    public void invokeChaincodeApiCall() throws IOException {
    }

    @Test
    public void queryChaincodeApiCall() throws IOException {
    }

}
