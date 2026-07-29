package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.endpoints.Endpoints;
import dev.qaplayground.pages.UploadFilePage;
import java.io.File;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

@Tag("UI")
public class UploadFileTest extends TestBase {

  @Autowired private UploadFilePage uploadFilePage;

  @BeforeEach
  public void setUp() {
    Selenide.open(Endpoints.UPLOAD_FILE_PAGE);
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
        expectedFileName,
        actualFileName,
        "Expected file name: " + expectedFileName + ", but got: " + actualFileName);
  }
}
