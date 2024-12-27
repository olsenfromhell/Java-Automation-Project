package dev.qaplayground;

import com.codeborne.selenide.Configuration;

public class BrowserConfig {

    public static void setup() {
        Configuration.baseUrl = "https://qaplayground.dev";
        Configuration.browser = "chrome";                 
        Configuration.headless = false;                
    }
}
