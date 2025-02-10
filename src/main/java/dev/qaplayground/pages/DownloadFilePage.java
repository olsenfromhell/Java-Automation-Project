package dev.qaplayground.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class DownloadFilePage {

    private SelenideElement fileDownloadButton = $("[id='file']");

    public File downloadFile() {
        return fileDownloadButton.download();
    }
}