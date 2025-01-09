package in.reqres;

import in.reqres.config.Configuration;
import in.reqres.endpoints.Endpoints;
import in.reqres.models.user.UserDataPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetUserByIdTest {

    @BeforeEach
    public void setUp() {
        Configuration.setup();
    }

    @Test
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
        Assertions.assertEquals(Integer.valueOf(userId), user.getData().getId(), "User id is not " + userId);
        Assertions.assertEquals(expectedEmail, user.getData().getEmail(), "User email is not " + expectedEmail);
        Assertions.assertEquals(expectedFirstName, user.getData().getFirst_name(), "User first name is not " + expectedFirstName);
        Assertions.assertEquals(expectedLastName, user.getData().getLast_name(), "User last name is not" + expectedLastName);

        Assertions.assertEquals(expectedSupportUrl, user.getSupport().getUrl(), "User support url is not " + expectedSupportUrl);
        Assertions.assertEquals(expectedSupportUrl, user.getSupport().getUrl(), "User support text is not " + expectedSupportText);

    }
}
