package utils;
import clients.BookingClient;

public class HealthCheck {
    public void verifyBookingServiceIsUp() {
        new BookingClient().healthCheck().then().statusCode(200);
    }
}