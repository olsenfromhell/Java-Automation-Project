package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.config.BrowserConfig;
import dev.qaplayground.config.TestConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestBase {

  @Autowired private BrowserConfig browserConfig;

  @BeforeEach
  public void setUpBrowser() {
    browserConfig.setup();
  }

  @AfterEach
  public void tearDown() {
    Selenide.closeWebDriver();
  }
}
