package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.endpoints.Endpoints;
import dev.qaplayground.pages.DownloadFilePage;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.*;

@Tag("UI")
public class DownloadFileTest extends TestBase {
  private DownloadFilePage downloadFilePage;

  @BeforeEach
  public void setUp() {
    Selenide.open(Endpoints.DOWNLOAD_FILE_PAGE);
    downloadFilePage = new DownloadFilePage();
  }

  @Test
  @DisplayName("Download a file and assert the file's name and size")
  public void downloadFileFromPageTest() throws FileNotFoundException {
    // Arrange
    String expectedFileName = "sample.pdf";
    long expectedFileSize = 1042157;

    // Act
    File downloadedFile = downloadFilePage.downloadFile();

    String actualFileName = downloadedFile.getName();
    long actualFileSize = downloadedFile.length();

    // Assert
    Assertions.assertAll(
        () ->
            Assertions.assertEquals(
                expectedFileName,
                actualFileName,
                "Expected file name: " + expectedFileName + ", but got: " + actualFileName),
        () ->
            Assertions.assertEquals(
                expectedFileSize,
                actualFileSize,
                "Expected file size: " + expectedFileSize + ", but got: " + actualFileSize));
  }
}
