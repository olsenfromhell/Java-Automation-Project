package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.UploadFilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

public class UploadFileTest {
    private UploadFilePage uploadFilePage;

    @BeforeEach
    public void setUp() {
        BrowserConfig.setup();
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
}
