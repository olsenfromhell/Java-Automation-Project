package in.reqres.register;

import in.reqres.config.Configuration;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.register.request.RegisterRequest;
import in.reqres.models.register.response.SuccessfulRegisterResponse;
import in.reqres.models.register.response.UnsuccsessfulRegisterResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

@Tag("API")
public class RegisterApiTests {

    /**
     * In these tests, the email, password, id, and token values are 'magic values', meaning they are hardcoded in reqres.in.
     * Therefore, I don't use fake data for these variables and constants when creating the user object.
     */

    @BeforeEach
    public void setUp() {
        Configuration.setup();
    }

    @Test
    @DisplayName("Register new user and check response")
    public void registerNewUserTest() {
        // Arrange
        int expectedId = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";

        RegisterRequest newUser = new RegisterRequest("eve.holt@reqres.in", "pistol");

        // Act
        SuccessfulRegisterResponse response = given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post(Endpoints.REGISTER_ENDPOINT)
                .then()
                .statusCode(HTTP_OK)
                .extract().as(SuccessfulRegisterResponse.class);

        int actualId = response.getId();
        String actualToken = response.getToken();

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        expectedId, actualId, "Expected user id: " + expectedId + ", but got: " + actualId
                ),
                () -> Assertions.assertEquals(
                        expectedToken, actualToken, "Expected user token: " + expectedToken + ", but got: " + actualToken
                )
        );
    }

    @Test
    @DisplayName("Try to register user without password and check error message")
    public void registerUserWithoutPasswordTest() {
        // Arrange
        RegisterRequest newUser = new RegisterRequest("sydney@fife");

        String expectedErrorMessage = "Missing password";

        // Act
        UnsuccsessfulRegisterResponse response = given()
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post(Endpoints.REGISTER_ENDPOINT)
                .then()
                .statusCode(HTTP_BAD_REQUEST)
                .extract().as(UnsuccsessfulRegisterResponse.class);

        String actualErrorMessage = response.getError();

        // Assert
        Assertions.assertEquals(
                expectedErrorMessage, actualErrorMessage,
                "Expected error message is: " + expectedErrorMessage + ", but got: " + actualErrorMessage
        );
    }
}
