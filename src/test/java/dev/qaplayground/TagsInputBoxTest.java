package dev.qaplayground;

import com.codeborne.selenide.Selenide;
import dev.qaplayground.pages.TagsInputBoxPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TagsInputBoxTest extends TestBase {
    private TagsInputBoxPage tagsInputBox;

    @BeforeEach
    public void setUp() {
        BrowserConfig.setup();
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
}
