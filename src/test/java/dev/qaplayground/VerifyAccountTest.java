package dev.qaplayground;

import dev.qaplayground.pages.VerifyAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VerifyAccountTest extends EnvConfig {
    VerifyAccount verifyAccount = new VerifyAccount();

    @Test
    @DisplayName("Enter valid code by pressing the key-up button or typing number and assert success message")
    public void verifyAccountTest() {
        open(Endpoints.verifyAccountPageEndpoint);

        verifyAccount.fillCodeInput("9");
        verifyAccount.waitForSuccessModal();

        Assertions.assertEquals("Success", VerifyAccount.successModal.getText(), "'Success' text not found");
    }
}
