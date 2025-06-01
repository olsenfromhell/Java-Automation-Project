package in.reqres;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.*;

import in.reqres.endpoints.Endpoints;
import in.reqres.models.resource.response.ResourceResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;
import org.junit.jupiter.api.*;

@Tag("API")
public class ResourceApiTests extends TestBase {

  @BeforeAll
  public static void setUp() {
    TestBase.setUp();
  }

  @Test
  @DisplayName("Get resource list and assert it's info")
  public void getResourceListInfoTest() {
    // Arrange
    int expectedPage = 1;
    int expectedPerPage = 6;
    int expectedTotal = 12;
    int expectedTotalPages = 2;

    String expectedSupportUrl =
        "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral";
    String expectedSupportText =
        "Tired of writing endless social media content? Let Content Caddy generate it for you.";

    // Act
    ResourceResponse response =
        given()
            .contentType(ContentType.JSON)
            .get(Endpoints.RESOURCES_ENDPOINT)
            .then()
            .extract()
            .as(ResourceResponse.class);

    List<ResourceResponse.Data> expectedData = response.getData();
    int actualPage = response.getPage();
    int actualPerPage = response.getPerPage();
    int actualTotal = response.getTotal();
    int actualTotalPages = response.getTotalPages();
    String actualSupportUrl = response.getSupport().getUrl();
    String actualSupportText = response.getSupport().getText();

    // Assert
    Assertions.assertAll(
        () -> assertNotNull(expectedData, "Data should not be null"),
        () -> assertFalse(expectedData.isEmpty(), "Data should not be empty"),
        () ->
            assertEquals(
                expectedPage,
                actualPage,
                "Expected 'page' value: " + expectedPage + ", but got: " + actualPage),
        () ->
            assertEquals(
                expectedPerPage,
                actualPerPage,
                "Expected 'per_page' value: " + expectedPerPage + ", but got: " + actualPerPage),
        () ->
            assertEquals(
                expectedTotal,
                actualTotal,
                "Expected 'total' value: " + expectedTotal + ", but got: " + actualTotal),
        () ->
            assertEquals(
                expectedTotalPages,
                actualTotalPages,
                "Expected 'total_pages' value: "
                    + expectedTotalPages
                    + ", but got: "
                    + actualTotalPages),
        () ->
            assertEquals(
                expectedSupportUrl,
                actualSupportUrl,
                "Expected 'url' value: " + expectedSupportUrl + ", but got: " + actualSupportUrl),
        () ->
            assertEquals(
                expectedSupportText,
                actualSupportText,
                "Expected 'text' value: "
                    + expectedSupportText
                    + ", but got: "
                    + actualSupportText));
  }

  @Test
  @DisplayName("Get nonexistent resource list and assert empty body")
  public void getEmptyResourceListInfoTest() {
    // Arrange
    String expectedBody = "{}";
    String resourceId = "23";

    // Act
    Response response =
        given()
            .contentType(ContentType.JSON)
            .get(Endpoints.RESOURCES_ENDPOINT + resourceId)
            .then()
            .statusCode(HTTP_NOT_FOUND)
            .extract()
            .response();

    String actualBody = response.body().asString();

    // Assert
    Assertions.assertEquals(expectedBody, actualBody, "The response body is not empty");
  }

  @Test
  @DisplayName("Verify 'years' key values are sorted in ascending order in response")
  public void verifyYearsSortedTest() {
    // Arrange

    // Act
    List<ResourceResponse.Data> response =
        given()
            .contentType(ContentType.JSON)
            .when()
            .get(Endpoints.RESOURCES_ENDPOINT)
            .then()
            .extract()
            .body()
            .jsonPath()
            .getList("data", ResourceResponse.Data.class);

    List<Integer> actualYears = response.stream().map(ResourceResponse.Data::getYear).toList();
    List<Integer> expectedYears = actualYears.stream().sorted().toList();

    // Assert
    Assertions.assertEquals(
        expectedYears, actualYears, "The 'years' key values are not sorted in ascending order");
  }
}
