package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public class AuthClient {
    String username = PropertyReader.getProperty("username");
    String password = PropertyReader.getProperty("password");
    String requestBody = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);

    public String getAuthToken(String userName, String passWord) {

        Response response = given().contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(RestAssured.baseURI+"/auth");

        return response.jsonPath().getString("token");
    }
}