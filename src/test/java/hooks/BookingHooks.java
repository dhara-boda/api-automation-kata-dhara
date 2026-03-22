package hooks;

import config.TestContext;
import io.cucumber.java.After;

import static io.restassured.RestAssured.given;

public class BookingHooks {

    @After
    public void tearDown() {

        if (TestContext.bookingIds.isEmpty()) {
            return;
        }

        for (Integer id : TestContext.bookingIds) {
            try {
                given()
                        .when()
                        .delete("/booking/" + id)
                        .then()
                        .log().ifValidationFails();

                System.out.println("Deleted booking ID: " + id);

            } catch (Exception e) {
                System.err.println("Failed to delete booking ID: " + id);
            }
        }

        // Clear after cleanup
        TestContext.bookingIds.clear();
    }
}