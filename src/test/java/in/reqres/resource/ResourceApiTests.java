package in.reqres.resource;

import in.reqres.config.Configuration;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.resource.response.ResourceResponsePOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceApiTests {

    @BeforeEach
    public void setUp() {
        Configuration.setup();
    }

    @Test
    @DisplayName("Get resource list and assert it's info")
    public void getResourceListInfoTest() {
        // Arrange
        int expectedPage = 1;
        int expectedPerPage = 6;
        int expectedTotal = 12;
        int expectedTotalPages = 2;

        String expectedSupportUrl = "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral";
        String expectedSupportText = "Tired of writing endless social media content? Let Content Caddy generate it for you.";

        // Act
        ResourceResponsePOJO response = given()
                .contentType(ContentType.JSON)
                .get(Endpoints.RESOURCES_ENDPOINT)
                .then()
                .extract().as(ResourceResponsePOJO.class);

        List<ResourceResponsePOJO.Data> expectedData = response.getData();
        int actualPage = response.getPage();
        int actualPerPage = response.getPerPage();
        int actualTotal = response.getTotal();
        int actualTotalPages = response.getTotalPages();
        String actualSupportUrl = response.getSupport().getUrl();
        String actualSupportText = response.getSupport().getText();

        // Assert
        Assertions.assertAll(
                () -> assertNotNull(
                        expectedData, "Data should not be null"
                ),
                () -> assertFalse(
                        expectedData.isEmpty(), "Data should not be empty"
                ),
                () -> assertEquals(
                        expectedPage, actualPage, "Expected 'page' value: " + expectedPage + ", but got: " + actualPage
                ),
                () -> assertEquals(
                        expectedPerPage, actualPerPage, "Expected 'per_page' value: " + expectedPerPage + ", but got: " + actualPerPage
                ),
                () -> assertEquals(
                        expectedTotal, actualTotal, "Expected 'total' value: " + expectedTotal + ", but got: " + actualTotal
                ),
                () -> assertEquals(
                        expectedTotalPages, actualTotalPages, "Expected 'total_pages' value: " + expectedTotalPages + ", but got: " + actualTotalPages
                ),
                () -> assertEquals(
                        expectedSupportUrl, actualSupportUrl, "Expected 'url' value: " + expectedSupportUrl + ", but got: " + actualSupportUrl
                ),
                () -> assertEquals(
                        expectedSupportText, actualSupportText, "Expected 'text' value: " + expectedSupportText + ", but got: " + actualSupportText
                )
        );
    }

    @Test
    @DisplayName("Get nonexistent resource list and assert empty body")
    public void getEmptyResourceListInfoTest() {
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

