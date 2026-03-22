package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Booking;
import org.apache.logging.log4j.Logger;
import steps.BookingSteps;
import utils.LoggerUtil;

import static io.restassured.RestAssured.given;

public class BookingClient {
    private static final String BOOKING_ENDPOINT = "/booking/";
    private static final Logger log = LoggerUtil.getLogger(BookingSteps.class);

    public Response getAll() {
        return given().when().get("/booking");
    }

    public Response create(Booking booking) {
        return given()
                .contentType("application/json")
                .log().all()  // request log
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .log().all()  // response log
                .extract()
                .response();
    }

    public Response deleteBooking(int id, String token) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .when()
                .log().all()
                .delete( "https://restful-booker.herokuapp.com/booking/"+id)
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .response();

    }

    // Get a booking by ID
    public Response getBookingById(int Id) {
        return given()
                .get(RestAssured.baseURI + BOOKING_ENDPOINT + Id);
    }

    public Response healthCheck() {
        return given().get(RestAssured.baseURI);
    }

}