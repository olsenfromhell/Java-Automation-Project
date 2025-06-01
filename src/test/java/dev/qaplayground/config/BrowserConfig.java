package dev.qaplayground.config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfig {
  public static void setup() {
    WebDriverManager.chromedriver().setup();

    Configuration.baseUrl = "https://qaplayground.dev";
    Configuration.browser = "chrome";
    Configuration.headless = true;
    Configuration.downloadsFolder = "src/test/resources/downloads";
  }
}
