package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.config.BrowserConfig;

public class TestBase {
    public void setUp() {
        BrowserConfig.setup(); // browser setup
    }

    public void tearDown() {
        Selenide.closeWebDriver(); // close web driver, just in case
    }
}
