package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    public void setUp() {
        BrowserConfig.setup(); // browser setup
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver(); // close web driver, just in case
    }
}
