package dev.qaplayground.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.io.File;

public class UploadFilePage {
  private static final SelenideElement uploadImageInput = $("[id='file-input']");
  private static final SelenideElement uploadedImageName = $("figure > figcaption");

  @Step("Upload image")
  public void uploadImage(File image) {
    uploadImageInput.uploadFile(image);
  }

  @Step("Return uploaded file name")
  public String returnUploadedImageName() {
    return uploadedImageName.getText();
  }
}
