
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

}
