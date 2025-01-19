package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.UploadFilePage;
import dev.qaplayground.endpoints.Pages;
import org.junit.jupiter.api.*;

import java.io.File;

@Tag("UI")
public class UploadFileTest extends TestBase {
    private UploadFilePage uploadFilePage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        Selenide.open(Pages.UPLOAD_FILE_PAGE);
        uploadFilePage = new UploadFilePage();
    }

    @Test
    @DisplayName("Upload an image file and assert the file name")
    public void uploadImageTest() {
        // Arrange
        File image = new File("src/test/resources/testfiles/funny_cat.jpeg");
        String expectedFileName = "funny_cat.jpeg";

        // Act
        uploadFilePage.uploadImage(image);
        String actualFileName = uploadFilePage.returnUploadedImageName();

        // Assert
        Assertions.assertEquals(
                expectedFileName, actualFileName, "Expected file name: " + expectedFileName + ", but got: " + actualFileName
        );
    }

    @AfterAll
    public static void tearDown() {
        TestBase.tearDown();
    }
}
