package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.config.BrowserConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
  @BeforeAll
  public static void browserSetup() {
    BrowserConfig.setup();
  }

  @AfterEach
  public void tearDown() {
    Selenide.closeWebDriver(); // close web driver, just in case
  }
}
