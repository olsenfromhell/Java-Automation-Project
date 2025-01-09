package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.TagsInputBoxPage;
import dev.qaplayground.endpoints.Pages;
import org.junit.jupiter.api.*;

public class TagsInputBoxTest extends TestBase {
    private TagsInputBoxPage tagsInputBox;

    @BeforeEach
    public void setUp() {
        super.setUp();
        Selenide.open(Pages.TAGS_INPUT_BOX_PAGE);
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
        Assertions.assertEquals(expectedTagCount, actualTagCount, "Tag has not been added");
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
        Assertions.assertEquals(expectedTagCount, actualTagCount, "Tag has not been removed");
    }

    @AfterAll
    public static void tearDown() {
        TestBase.tearDown();
    }
}
