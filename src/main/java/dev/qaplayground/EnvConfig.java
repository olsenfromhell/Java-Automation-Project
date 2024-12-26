package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;

public class EnvConfig {
    public static void open(String url) {
        Selenide.open(Endpoints.baseUrl + url);
    }

    @AfterAll
    protected static void close() {
        Selenide.closeWebDriver();
    }
}
