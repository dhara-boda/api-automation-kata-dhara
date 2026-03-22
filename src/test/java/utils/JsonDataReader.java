package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Booking;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonDataReader {

    public static List<Booking> getBookingData() {
        try {
            Gson gson = new Gson();

            Reader reader = new FileReader("src/test/resources/datafiles/booking.json");

            Type bookingListType = new TypeToken<List<Booking>>() {}.getType();

            return gson.fromJson(reader, bookingListType);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }

}
