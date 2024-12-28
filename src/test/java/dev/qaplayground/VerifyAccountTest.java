package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.VerifyAccountPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VerifyAccountTest extends TestBase {
    private VerifyAccountPage verifyAccount;

    @BeforeEach
    public void setUp() {
        BrowserConfig.setup();
        Selenide.open(Pages.VERIFY_ACCOUNT_PAGE);
        verifyAccount = new VerifyAccountPage();
    }

    @Test
    @DisplayName("Enter valid code by pressing the key-up button or typing number and assert success message")
    public void verifyAccountTest() {
        // Arrange
        String validCode = "9";
        String expectedMessage = "Success";

        // Act
        verifyAccount.fillCodeInput(validCode);
        String actualMessage = verifyAccount.returnTextFromSuccessModal();

        // Assert
        Assertions.assertEquals(expectedMessage, actualMessage, "'Success' text not found");
    }
}
