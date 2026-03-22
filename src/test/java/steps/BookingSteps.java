package steps;


import assertions.BookingAssertions;
import clients.AuthClient;
import clients.BookingClient;
import config.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.Booking;
import utils.HealthCheck;
import utils.JsonDataReader;
import utils.PropertyReader;

import java.util.List;


public class BookingSteps {
    BookingClient client = new BookingClient();
    Response response;
    private static String token;
    private final AuthClient authClient = new AuthClient();
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

    @Then("Verify status {int}")
    public void verifyStatus(int code) {
        BookingAssertions.verifyStatus(response, code);
    }
    @Given("the booking service is available")
    public void serviceAvailable() {
        new HealthCheck().verifyBookingServiceIsUp();
    }

    @When("Verify payload")
    public void verifyPayload() {
        List<Booking> bookings = JsonDataReader.getBookingData();
        Booking booking = bookings.get(0); // pick first booking for test
        // Validate payload
        BookingAssertions.verifyBooking(response, booking);
    }

    @Given("Get all bookings")
    public void getAll() {
        response = client.getAll();
    }

    @When("I delete the booking")
    public void deleteBooking() {
        token = authClient.getAuthToken(PropertyReader.getProperty("username"),PropertyReader.getProperty("password"));
        client.deleteBooking(bookingId, token);
    }

    @Then("the booking should not be retrievable")
    public void verifyDeletedBooking() {
        int statusCode = client.getBookingById(bookingId).getStatusCode();
        assert statusCode == 404 : "Expected status code 404 for deleted booking but found " + statusCode;
    }

    @When("I create a booking with missing firstname")
    public void createBookingMissingFirstname() {
        Booking booking = JsonDataReader.getBookingData().get(0);
        booking.setFirstname(null); // remove firstname
        response = client.create(booking);
    }

    @When("I create a booking with invalid totalprice type")
    public void createBookingInvalidTotalprice() {
        List<Booking> bookings = JsonDataReader.getBookingData();
        Booking booking = bookings.get(0); // pick first booking for test
        booking.setTotalprice("abc");
        response = client.create(booking);
    }

    @When("I create a booking with checkout before checkin")
    public void createBookingInvalidDates() {
        Booking booking = JsonDataReader.getBookingData().get(0);
        booking.getBookingdates().setCheckin(PropertyReader.getTestData("setcheckin"));
        booking.getBookingdates().setCheckout(PropertyReader.getTestData("setcheckout"));
        response = client.create(booking);
    }
}