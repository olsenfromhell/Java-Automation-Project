package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    public void setUp() {
        BrowserConfig.setup(); // Вызываем настройку браузера
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver(); // Закрываем WebDriver
    }
}
