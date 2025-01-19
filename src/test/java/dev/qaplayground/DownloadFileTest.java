package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.endpoints.Pages;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

@Tag("UI")
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

        String actualFileName = downloadedFile.getName();
        long actualFileSize = downloadedFile.length();


        // Assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(downloadedFile.exists(), "File is not downloaded"),
                () -> Assertions.assertTrue(actualFileSize > 0, "File must be not empty"),

                () -> Assertions.assertEquals(
                        expectedFileName, actualFileName, "Expected file name: " + expectedFileName + ", but got: " + actualFileName
                ),
                () -> Assertions.assertEquals(
                        expectedFileSize, actualFileSize, "Expected file size: " + expectedFileSize + ", but got: " + actualFileSize
                )
        );
    }

    @AfterAll
    public static void tearDown() {
        TestBase.tearDown();
    }
}
