package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.UploadFilePage;
import dev.qaplayground.endpoints.Pages;
import org.junit.jupiter.api.*;

import java.io.File;

public class UploadFileTest extends TestBase {
    private UploadFilePage uploadFilePage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        Selenide.open(Pages.UPLOAD_FILE_PAGE);
        uploadFilePage = new UploadFilePage();
    }

    @Test
    @DisplayName("Upload an image file and assert the file's name")
    public void uploadImageTest() {
        // Arrange
        File image = new File("src/test/resources/testfiles/funny_cat.jpeg");
        String expected = "funny_cat.jpeg";

        // Act
        uploadFilePage.uploadImage(image);
        String actual = uploadFilePage.returnUploadedImageName();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @AfterAll
    public static void tearDown() {
        TestBase.tearDown();
    }
}
