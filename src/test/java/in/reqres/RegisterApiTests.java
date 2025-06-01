package in.reqres;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;

import in.reqres.builder.RegisterRequestBuilder;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.register.request.RegisterRequest;
import in.reqres.models.register.response.SuccessfulRegisterResponse;
import in.reqres.models.register.response.UnsuccessfulRegisterResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

@Tag("API")
public class RegisterApiTests extends TestBase {

  /**
   * In these tests, the email, password, id, and token values are 'magic values', meaning they are
   * hardcoded in reqres.in. Therefore, I don't use fake data for these variables and constants when
   * creating the user object.
   */
  @BeforeAll
  public static void setUp() {
    TestBase.setUp();
  }

  @Test
  @DisplayName("Register new user and check response")
  public void registerNewUserTest() {
    // Arrange
    String email = "eve.holt@reqres.in";
    String password = "pistol";
    int expectedId = 4;
    String expectedToken = "QpwL5tke4Pnpja7X4";

    RegisterRequest registrationRequest =
        RegisterRequestBuilder.registrationRequest().email(email).password(password).build();

    // Act
    SuccessfulRegisterResponse response =
        given()
            .contentType(ContentType.JSON)
            .body(registrationRequest)
            .when()
            .post(Endpoints.REGISTER_ENDPOINT)
            .then()
            .statusCode(HTTP_OK)
            .extract()
            .as(SuccessfulRegisterResponse.class);

    int actualId = response.getId();
    String actualToken = response.getToken();

    // Assert
    Assertions.assertAll(
        () ->
            Assertions.assertEquals(
                expectedId, actualId, "Expected user id: " + expectedId + ", but got: " + actualId),
        () ->
            Assertions.assertEquals(
                expectedToken,
                actualToken,
                "Expected user token: " + expectedToken + ", but got: " + actualToken));
  }

  @Test
  @DisplayName("Try to register user without password and check error message")
  public void registerUserWithoutPasswordTest() {
    // Arrange
    String email = "sydney@fife";
    String expectedErrorMessage = "Missing password";

    RegisterRequest registerRequest =
        RegisterRequestBuilder.registrationRequest().email(email).build();

    // Act
    UnsuccessfulRegisterResponse response =
        given()
            .contentType(ContentType.JSON)
            .body(registerRequest)
            .when()
            .post(Endpoints.REGISTER_ENDPOINT)
            .then()
            .statusCode(HTTP_BAD_REQUEST)
            .extract()
            .as(UnsuccessfulRegisterResponse.class);

    String actualErrorMessage = response.getError();

    // Assert
    Assertions.assertEquals(
        expectedErrorMessage,
        actualErrorMessage,
        "Expected error message is: " + expectedErrorMessage + ", but got: " + actualErrorMessage);
  }
}
