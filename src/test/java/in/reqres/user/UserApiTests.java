package in.reqres.user;

import in.reqres.config.Configuration;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.user.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserApiTests {

    @BeforeEach
    public void setUp() {
        Configuration.setup();
    }

    @Test
    @DisplayName("Get user by ID and assert the user's info")
    public void getUserByIdTest() {
        // Arrange
        String userId = "2";

        String expectedEmail = "janet.weaver@reqres.in";
        String expectedFirstName = "Janet";
        String expectedLastName = "Weaver";

        String expectedSupportUrl = "https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral";
        String expectedSupportText = "Tired of writing endless social media content? Let Content Caddy generate it for you.";

        // Act
        UserPOJO response = given()
                .contentType(ContentType.JSON)
                .get(Endpoints.USERS_ENDPOINT + userId)
                .then().extract().as(UserPOJO.class);

        UserPOJO.Data expectedData = response.getData();
        int actualId = response.getData().getId();
        String actualEmail = response.getData().getEmail();
        String actualFirstName = response.getData().getFirstName();
        String actualLastName = response.getData().getLastName();
        String actualSupportUrl = response.getSupport().getUrl();
        String actualSupportText = response.getSupport().getText();

        // Assert
        Assertions.assertAll(
                () -> assertNotNull(expectedData, "Data should not be null"),

                () -> assertEquals(Integer.valueOf(userId), actualId, "User id is not as expected"),
                () -> assertEquals(expectedEmail, actualEmail, "User email is not as expected"),
                () -> assertEquals(expectedFirstName, actualFirstName, "User first name is not as expected"),
                () -> assertEquals(expectedLastName, actualLastName, "User last name is not as expected"),

                () -> assertEquals(expectedSupportUrl, actualSupportUrl, "User support url is not as expected"),
                () -> assertEquals(expectedSupportText, actualSupportText, "User support text is not as expected")
        );

    }

    @Test
    @DisplayName("Get nonexistent user by ID and assert empty body")
    public void getNonExistentUserByIdTest() {
        // Arrange
        String userId = "23";
        String expectedBody = "{}";

        // Act
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(Endpoints.USERS_ENDPOINT + userId)
                .then()
                .statusCode(HTTP_NOT_FOUND)
                .extract().response();

        String actualBody = response.body().asString();

        // Assert
        Assertions.assertEquals(expectedBody, actualBody, "The response body is not empty");
    }
}
