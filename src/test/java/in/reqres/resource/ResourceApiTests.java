package in.reqres.resource;

import in.reqres.config.Configuration;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.resource.ResourcePOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResourceApiTests {

    @BeforeEach
    public void setUp() {
        Configuration.setup();
    }

    @Test
    @DisplayName("Get resource list and assert it's info")
    public void getResourceListInfo() {
        // Arrange
        int expectedPage = 1;
        int expectedPerPage = 6;
        int expectedTotal = 12;
        int expectedTotalPages = 2;

        String expectedSupportUrl = "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral";
        String expectedSupportText = "Tired of writing endless social media content? Let Content Caddy generate it for you.";

        // Act
        ResourcePOJO response = given()
                .contentType(ContentType.JSON)
                .get(Endpoints.RESOURCES_ENDPOINT)
                .then()
                .extract().as(ResourcePOJO.class);

        List<ResourcePOJO.Data> expectedData = response.getData();
        int actualPage = response.getPage();
        int actualPerPage = response.getPerPage();
        int actualTotal = response.getTotal();
        int actualTotalPages = response.getTotalPages();
        String actualSupportUrl = response.getSupport().getUrl();
        String actualSupportText = response.getSupport().getText();

        // Assert
        Assertions.assertAll(
                () -> assertNotNull(expectedData, "Data should not be null"),

                () -> assertEquals(expectedPage, actualPage, "Page number is not as expected"),
                () -> assertEquals(expectedPerPage, actualPerPage, "Per page is not as expected"),
                () -> assertEquals(expectedTotal, actualTotal, "Total is not as expected"),
                () -> assertEquals(expectedTotalPages, actualTotalPages, "Total pages is not as expected"),
                () -> assertEquals(expectedSupportUrl, actualSupportUrl, "Support URL is not as expected"),
                () -> assertEquals(expectedSupportText, actualSupportText, "Support text is not as expected")
        );
    }

    @Test
    @DisplayName("Get nonexistent resource list and assert empty body")
    public void getEmptyResourceListInfo() {
        // Arrange
        String expectedBody = "{}";
        String resourceId = "23";

        // Act
        Response response = given()
                .contentType(ContentType.JSON)
                .get(Endpoints.RESOURCES_ENDPOINT + resourceId)
                .then()
                .statusCode(HTTP_NOT_FOUND)
                .extract().response();

        String actualBody = response.body().asString();

        // Assert
        Assertions.assertEquals(expectedBody, actualBody, "The response body is not empty");
    }
}

