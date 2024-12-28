package dev.qaplayground.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VerifyAccountPage {
    // locators
    private final List<SelenideElement> inputField = $$("input[type='number']");
    private final SelenideElement successModal = $("[class='info success']");


    // methods
    @Step("Fill code input")
    public void fillCodeInput(String value) {
        inputField.forEach(selenideElement -> selenideElement.sendKeys(value));
    }

    @Step("Return 'Success' text from success modal")
    public String returnTextFromSuccessModal() {
        return successModal.getText();
    }
}
