package dev.qaplayground.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import java.io.File;
import org.springframework.stereotype.Component;

@Component
public class DownloadFilePage {

  private final SelenideElement fileDownloadButton = $("[id='file']");

  public File downloadFile() {
    return fileDownloadButton.download();
  }
}
