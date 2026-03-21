package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Booking;

import static io.restassured.RestAssured.given;

public class BookingClient {
    private static final String BOOKING_ENDPOINT = "/booking/";


    public Response getAll() {
        return given().when().get("/booking");
    }

    public Response create(Booking booking) {
        return given()
                .contentType("application/json")
                .body(booking)
                .when()
                .post("/booking");
    }


    public Response healthCheck() {
        return given().get(RestAssured.baseURI);
    }

}