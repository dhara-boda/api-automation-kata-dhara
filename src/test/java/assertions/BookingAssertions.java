
package assertions;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import model.Booking;

import static org.assertj.core.api.Assertions.assertThat;

public class BookingAssertions {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void verifyStatus(Response response, int expected) {
        assertThat(response.getStatusCode()).isEqualTo(expected);
    }
    public static void verifyBooking(Response response, Booking expected) {
        Booking actual = response.jsonPath().getObject("booking", Booking.class);

        assertThat(actual.getFirstname()).isEqualTo(expected.getFirstname());
        assertThat(actual.getLastname()).isEqualTo(expected.getLastname());
        assertThat(actual.getTotalprice()).isEqualTo(expected.getTotalprice());
        assertThat(actual.isDepositpaid()).isEqualTo(expected.isDepositpaid());
        assertThat(actual.getBookingdates().getCheckin())
                .isEqualTo(expected.getBookingdates().getCheckin());
        assertThat(actual.getBookingdates().getCheckout())
                .isEqualTo(expected.getBookingdates().getCheckout());
        assertThat(actual.getAdditionalneeds()).isEqualTo(expected.getAdditionalneeds());
    }
}
