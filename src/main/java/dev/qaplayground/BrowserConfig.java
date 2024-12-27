package dev.qaplayground;

import com.codeborne.selenide.Configuration;

public class BrowserConfig {

    public static void setup() {
        Configuration.baseUrl = "https://qaplayground.dev"; // Настраиваем базовый URL
        Configuration.browser = "chrome";                 // Устанавливаем браузер (можно поменять на другой)
        Configuration.headless = false;                   // Выключаем headless режим (можно включить, если нужно)
    }
}
