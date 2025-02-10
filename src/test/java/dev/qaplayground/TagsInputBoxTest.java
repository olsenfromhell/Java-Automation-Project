package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.TagsInputBoxPage;
import dev.qaplayground.endpoints.Endpoints;
import org.junit.jupiter.api.*;

@Tag("UI")
public class TagsInputBoxTest extends TestBase {
    private TagsInputBoxPage tagsInputBox;

    @BeforeEach
    public void setUp() {
        super.setUp();
        Selenide.open(Endpoints.TAGS_INPUT_BOX_PAGE);
        tagsInputBox = new TagsInputBoxPage();
    }

    @Test
    @DisplayName("Add tag and verify it's presence")
    public void addTagsTest() {
        // Arrange
        int initTagCount = tagsInputBox.getTagCount();
        int expectedTagCount = initTagCount + 1;

        // Act
        tagsInputBox.addTag();
        int actualTagCount = tagsInputBox.getTagCount();

        // Assert
        Assertions.assertEquals(
                expectedTagCount, actualTagCount, "Expected tag count: " + expectedTagCount + ", but got: " + actualTagCount
        );
    }

    @Test
    @DisplayName("Remove tag and verify it's removed")
    public void removeTagsTest() {
        // Arrange
        int initTagCount = tagsInputBox.getTagCount();
        int expectedTagCount = initTagCount - 1;

        // Act
        tagsInputBox.removeTag();
        int actualTagCount = tagsInputBox.getTagCount();

        // Assert
        Assertions.assertEquals(
                expectedTagCount, actualTagCount, "Expected tag count: " + expectedTagCount + ", but got: " + actualTagCount
        );
    }

    @AfterEach
    public void tearDown() {
        super.tearDown();
    }
}
