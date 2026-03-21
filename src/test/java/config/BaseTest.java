package config;

import io.restassured.RestAssured;

public class BaseTest {
    public static void setup() {
        RestAssured.baseURI = ConfigManager.getBaseUrl();
    }
}