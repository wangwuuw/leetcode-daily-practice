package com.leetcode.json.parser.jsonstream.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import com.leetcode.json.parser.jsonstream.JsonBuilder;
import com.leetcode.json.parser.jsonstream.JsonReader;
import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.adapter.DateTypeAdapter;
import com.leetcode.json.parser.jsonstream.adapter.TimeTypeAdapter;
import com.leetcode.json.parser.jsonstream.annotation.Pattern;
import org.junit.Test;


public class JsonReaderToRegisteredTypeTest {

    @Test
    public void testUseTypeAdapter() throws Exception {
        String s = "{ \"rooms\": 1, \"start\": \"2015-01-01\", \"end\": \"2015-01-05\", \"breakfast\": \"07:10\" }";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(s);
        HotelBooking hotel = js.parse(HotelBooking.class);
        assertEquals(1, hotel.rooms);
        assertEquals(LocalDate.of(2015, 1, 1), hotel.start);
        assertEquals(LocalDate.of(2015, 1, 5), hotel.end);
        assertEquals(LocalTime.of(7, 10), hotel.breakfast);
    }

    @Test(expected= JsonValidateException.class)
    public void testUseTypeAdapterWithValidation() throws Exception {
        String s = "{ \"rooms\": 1, \"start\": \"2015-A1-01\", \"end\": \"2015-01-05\", \"breakfast\": \"07:10\" }";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(s);
        js.parse(HotelBooking.class);
    }
}

class HotelBooking {
    int rooms;
    @Pattern("^\\d\\d\\d\\d\\-\\d\\d\\-\\d\\d$")
    LocalDate start;
    LocalDate end;
    LocalTime breakfast;
}
