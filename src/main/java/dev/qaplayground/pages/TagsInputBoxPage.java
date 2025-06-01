package dev.qaplayground.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.DataFaker;

public class TagsInputBoxPage {
  private static final By tag = By.cssSelector("[class='uit uit-multiply']");
  private static final SelenideElement closeTagBtn = $(tag);
  private static final ElementsCollection tagList = $$(tag);
  private static final SelenideElement inputField = $("input[type='text']");

  @Step("Delete tag")
  public void removeTag() {
    closeTagBtn.click();
  }

  @Step("Count displayed tags")
  public int getTagCount() {
    return tagList.shouldBe(CollectionCondition.sizeGreaterThan(0)).size();
  }

  @Step("Add new tag")
  public void addTag() {
    inputField.setValue(DataFaker.anyBeerName).pressEnter();
  }
}
