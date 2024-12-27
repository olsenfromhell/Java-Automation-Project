package dev.qaplayground.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VerifyAccountPage {
    // locators
    private final List<SelenideElement> inputField = $$("input[type='number']");
    private final SelenideElement successModal = $("[class='info success']");


    // methods
    public void fillCodeInput(String value) {
        inputField.stream()
                .iterator()
                .next()
                .setValue(value);
    }

    public String returnTextFromSuccessModal() {
        return successModal.getText();
    }
}
