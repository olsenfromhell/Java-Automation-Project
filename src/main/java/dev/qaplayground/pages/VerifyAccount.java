package dev.qaplayground.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VerifyAccount {
    // locators
    private final List<SelenideElement> inputField = $$("input[type='number']");
    public static final SelenideElement successModal = $(By.xpath("//*[@class='info success' and contains(text(), 'Success')]"));


    // methods
    public void fillCodeInput(String value) {
        for (SelenideElement selenideElement : inputField) {
            selenideElement.setValue(value);
        }
    }

    public void waitForSuccessModal() {
        successModal.shouldBe(Condition.visible);
    }
}
