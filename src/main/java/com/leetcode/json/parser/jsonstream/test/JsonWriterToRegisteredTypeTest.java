package com.leetcode.json.parser.jsonstream.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import com.leetcode.json.parser.jsonstream.JsonBuilder;
import com.leetcode.json.parser.jsonstream.JsonWriter;
import com.leetcode.json.parser.jsonstream.adapter.DateTypeAdapter;
import com.leetcode.json.parser.jsonstream.adapter.TimeTypeAdapter;
import org.junit.Test;


public class JsonWriterToRegisteredTypeTest {

    static final float DELTA = 0.00001f;

    JsonWriter prepareJsonWriter() {
        return new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createWriter();
    }

    @Test
    public void testWriteWithTypeAdapters() throws Exception {
        Ticket t = new Ticket();
        JsonWriter jsonWriter = prepareJsonWriter();
        jsonWriter.write(t);
        String jsonStr = jsonWriter.toString();
        System.out.println(jsonStr);
        assertTrue(jsonStr.indexOf("\"startDate\":\"2015-01-05\"") > 0);
        assertTrue(jsonStr.indexOf("\"startTime\":\"09:25:30\"") > 0);
    }

}

class Ticket {
    String id = "s0001";
    String passenger = "Bob";
    LocalDate startDate = LocalDate.of(2015, 1, 5);
    LocalTime startTime = LocalTime.of(9, 25, 30);
}
