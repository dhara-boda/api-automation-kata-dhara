package steps;


import clients.BookingClient;
import config.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.Booking;
import utils.JsonDataReader;
import java.util.List;


public class BookingSteps {
    BookingClient client = new BookingClient();
    Response response;
    private static int bookingId;


    @Before
    public void setup() {
        BaseTest.setup();
    }

    @When("Create booking")
    public void createBooking() {
        List<Booking> bookings = JsonDataReader.getBookingData();
        Booking booking = bookings.get(0); // pick first booking for test
        response = client.create(booking);

        // Capture booking ID
        bookingId = response.jsonPath().getInt("bookingid");

    }


}