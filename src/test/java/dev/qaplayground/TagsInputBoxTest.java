package dev.qaplayground;

import dev.qaplayground.pages.TagsInputBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TagsInputBoxTest extends EnvConfig {
    TagsInputBox tagsInputBox = new TagsInputBox();

    @Test
    @DisplayName("Add tag and assert tag's presence and count")
    public void addTagsTest() {
        open(Endpoints.tagsInputBoxPageEndpoint);

        int tagCount = tagsInputBox.getTagCount();

        tagsInputBox.addTag();

        Assertions.assertEquals(tagCount + 1, tagsInputBox.getTagCount(), "Tag has not been added");
    }

    @Test
    @DisplayName("Remove tag and assert tag's presence and count")
    public void removeTagsTest() {
        open(Endpoints.tagsInputBoxPageEndpoint);

        int tagCount = tagsInputBox.getTagCount();

        tagsInputBox.removeTag();

        Assertions.assertEquals(tagCount - 1, tagsInputBox.getTagCount(), "Tag has not been removed");
    }
}
