package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class DownloadFileTest extends TestBase {

    @BeforeEach
    public void setUp() {
        super.setUp();
        Selenide.open(Pages.DOWNLOAD_FILE_PAGE);
    }

    @Test
    @DisplayName("Download a file and assert the file's name and size")
    public void downloadFileFromPageTest() throws FileNotFoundException {
        // Arrange
        String expectedFileName = "sample.pdf";
        long expectedFileSize = 1042157;

        // Act
        File downloadedFile = $("[id='file']").download();

        // Assert
        Assertions.assertTrue(downloadedFile.exists(), "File is not downloaded");
        Assertions.assertTrue(downloadedFile.length() > 0, "File must be not empty");

        Assertions.assertEquals(expectedFileName, downloadedFile.getName(), "Name of the file must be 'sample.pdf'");
        Assertions.assertEquals(expectedFileSize, downloadedFile.length(), "File size must be 1042157 Byte");
    }

    @AfterAll
    public static void tearDown() {
        TestBase.tearDown();
    }
}
