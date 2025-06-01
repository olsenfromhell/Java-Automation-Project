package dev.qaplayground.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class VerifyAccountPage {
  private final ElementsCollection inputField = $$("input[type='number']");
  private final SelenideElement successModal = $("[class='info success']");

  @Step("Fill code input")
  public void fillCodeInput(String value) {
    inputField.asDynamicIterable().forEach(selenideElement -> selenideElement.sendKeys(value));
  }

  @Step("Return 'Success' text from success modal")
  public String returnTextFromSuccessModal() {
    return successModal.getText();
  }
}
