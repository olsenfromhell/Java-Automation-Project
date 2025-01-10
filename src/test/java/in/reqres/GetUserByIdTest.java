package in.reqres;

import in.reqres.config.Configuration;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.user.UserDataPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetUserByIdTest {

    @BeforeEach
    public void setUp() {
        Configuration.setup();
    }

    @Test
    @DisplayName("Get user by ID and assert the user's info")
    public void getUserByIdTest() {
        // Arrange
        Response response;
        String userId = "2";

        String expectedEmail = "janet.weaver@reqres.in";
        String expectedFirstName = "Janet";
        String expectedLastName = "Weaver";

        String expectedSupportUrl = "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral";
        String expectedSupportText  = "Tired of writing endless social media content? Let Content Caddy generate it for you.";

        // Act
        response = given()
                .contentType(ContentType.JSON)
                .get(Endpoints.USERS_ENDPOINT + userId);

        UserDataPOJO user =  response.getBody().as(UserDataPOJO.class);

        // Assert
        Assertions.assertAll(
                () -> assertEquals(Integer.valueOf(userId), user.getData().getId(), "User id is not " + userId),
                () -> assertEquals(expectedEmail, user.getData().getEmail(), "User email is not " + expectedEmail),
                () -> assertEquals(expectedFirstName, user.getData().getFirst_name(), "User first name is not " + expectedFirstName),
                () -> assertEquals(expectedLastName, user.getData().getLast_name(), "User last name is not" + expectedLastName),

                () -> assertEquals(expectedSupportUrl, user.getSupport().getUrl(), "User support url is not " + expectedSupportUrl),
                () -> assertEquals(expectedSupportUrl, user.getSupport().getUrl(), "User support text is not " + expectedSupportText)
        );

    }

    @Test
    @DisplayName("Get nonexistent user by ID and assert 404 (HTTP_NOT_FOUND) status code and empty body")
    public void getNonExistentUserByIdTest() {
        // Arrange
        Response response;
        String userId = "23";
        String expectedBody = "{}";

        // Act
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.USERS_ENDPOINT + userId)
                .then()
                .statusCode(HTTP_NOT_FOUND)
                .extract().response();

        String actualBody = response.body().asString();

        // Assert
        Assertions.assertEquals(expectedBody, actualBody, "The response body is not as expected");
    }
}
