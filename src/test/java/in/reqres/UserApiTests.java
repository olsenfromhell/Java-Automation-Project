package in.reqres;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import in.reqres.endpoints.Endpoints;
import in.reqres.models.user.request.CreateUserRequest;
import in.reqres.models.user.response.CreateUserResponse;
import in.reqres.models.user.response.UserInfoResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import utils.DataFaker;

@Tag("API")
public class UserApiTests extends TestBase {

  @BeforeAll
  public static void setUp() {
    TestBase.setUp();
  }

  @Test
  @DisplayName("Get single user by ID and assert user's info")
  public void getUserByIdTest() {
    // Arrange
    String userId = "2";

    String expectedEmail = "janet.weaver@reqres.in";
    String expectedFirstName = "Janet";
    String expectedLastName = "Weaver";

    String expectedSupportUrl =
        "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral";
    String expectedSupportText =
        "Tired of writing endless social media content? Let Content Caddy generate it for you.";

    // Act
    UserInfoResponse response =
        given()
            .contentType(ContentType.JSON)
            .get(Endpoints.USERS_ENDPOINT + userId)
            .then()
            .extract()
            .as(UserInfoResponse.class);

    UserInfoResponse.Data expectedData = response.getData();
    int actualId = response.getData().getId();
    String actualEmail = response.getData().getEmail();
    String actualFirstName = response.getData().getFirstName();
    String actualLastName = response.getData().getLastName();
    String actualSupportUrl = response.getSupport().getUrl();
    String actualSupportText = response.getSupport().getText();

    // Assert
    Assertions.assertAll(
        () -> assertNotNull(expectedData, "Data should not be null"),
        () ->
            assertEquals(
                Integer.valueOf(userId),
                actualId,
                "Expected user's id: " + userId + ", but got: " + actualId),
        () ->
            assertEquals(
                expectedEmail,
                actualEmail,
                "Expected user's email: " + expectedEmail + ", but got: " + actualEmail),
        () ->
            assertEquals(
                expectedFirstName,
                actualFirstName,
                "Expected user's first name: "
                    + expectedFirstName
                    + ", but got: "
                    + actualFirstName),
        () ->
            assertEquals(
                expectedLastName,
                actualLastName,
                "Expected user's name: " + expectedLastName + ", but got: " + actualLastName),
        () ->
            assertEquals(
                expectedSupportUrl,
                actualSupportUrl,
                "Expected user's support url: "
                    + expectedSupportUrl
                    + ", but got: "
                    + actualSupportUrl),
        () ->
            assertEquals(
                expectedSupportText,
                actualSupportText,
                "Expected user's text: "
                    + expectedSupportText
                    + ", but got: "
                    + actualSupportText));
  }

  @Test
  @DisplayName("Get nonexistent user by ID and assert empty body")
  public void getNonExistentUserByIdTest() {
    // Arrange
    String userId = "23";
    String expectedBody = "{}";

    // Act
    Response response =
        given()
            .contentType(ContentType.JSON)
            .when()
            .get(Endpoints.USERS_ENDPOINT + userId)
            .then()
            .statusCode(HTTP_NOT_FOUND)
            .extract()
            .response();

    String actualBody = response.body().asString();

    // Assert
    Assertions.assertEquals(expectedBody, actualBody, "The response body is not empty");
  }

  @Test
  @DisplayName("Send a POST request to create user and verify user is created")
  public void createUserWithPostRequestTest() {
    // Arrange
    CreateUserRequest newUser = new CreateUserRequest(DataFaker.userName, DataFaker.userJob);

    String expectedName = newUser.getName();
    String expectedJob = newUser.getJob();

    // Act
    CreateUserResponse response =
        given()
            .contentType(ContentType.JSON)
            .body(newUser)
            .when()
            .post(Endpoints.USERS_ENDPOINT)
            .then()
            .statusCode(HTTP_CREATED)
            .extract()
            .as(CreateUserResponse.class);

    String actualName = response.getName();
    String actualJob = response.getJob();

    String expectedId = response.getId();
    String expectedCreatedAt = response.getId();

    // Assert
    Assertions.assertAll(
        () ->
            assertEquals(
                expectedName,
                actualName,
                "Expected user's name: " + expectedName + ", but got: " + actualName),
        () ->
            assertEquals(
                expectedJob,
                actualJob,
                "Expected user's job: " + expectedJob + ", but got: " + actualJob),
        () -> assertNotNull(expectedId, "User id should not be null"),
        () -> assertNotNull(expectedCreatedAt, "'createdAt' value should not be null"));
  }
}
