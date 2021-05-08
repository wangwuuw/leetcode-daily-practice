package com.leetcode.json.parser.jsonstream.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.leetcode.json.parser.jsonstream.JsonBuilder;
import com.leetcode.json.parser.jsonstream.JsonReader;
import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.adapter.DateTypeAdapter;
import com.leetcode.json.parser.jsonstream.adapter.TimeTypeAdapter;
import com.leetcode.json.parser.jsonstream.annotation.ExclusiveMinimum;
import com.leetcode.json.parser.jsonstream.annotation.Format;
import com.leetcode.json.parser.jsonstream.annotation.MaxLength;
import com.leetcode.json.parser.jsonstream.annotation.MaximumInteger;
import com.leetcode.json.parser.jsonstream.annotation.MaximumNumber;
import com.leetcode.json.parser.jsonstream.annotation.MinLength;
import com.leetcode.json.parser.jsonstream.annotation.MinimumInteger;
import com.leetcode.json.parser.jsonstream.annotation.MinimumNumber;
import com.leetcode.json.parser.jsonstream.annotation.Pattern;
import com.leetcode.json.parser.jsonstream.annotation.Required;
import com.leetcode.json.parser.jsonstream.annotation.UniqueItems;
import com.leetcode.json.parser.jsonstream.format.Hex;
import com.leetcode.json.parser.jsonstream.format.Numeric;
import org.junit.Test;


public class JsonReaderToValidateTest {

    @Test
    public void testValidateOk() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"100101\" "
                + "}";
        String jsonOrder = "{"
                + " \"productId\":\"A00001\", "
                + " \"price\":10.8, "
                + " \"num\":5, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test(expected= JsonValidateException.class)
    public void testValidateFailedForRequiredProductIdIsNull() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"100101\" "
                + "}";
        String jsonOrder = "{"
                + " \"productId\":null, "
                + " \"price\":10.8, "
                + " \"num\":5, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test(expected=JsonValidateException.class)
    public void testValidateFailedForRequiredProductIdIsMissing() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"100101\" "
                + "}";
        String jsonOrder = "{"
                + " \"price\":10.8, "
                + " \"num\":5, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test(expected=JsonValidateException.class)
    public void testValidateFailedForNumberIs0() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"100101\" "
                + "}";
        String jsonOrder = "{"
                + " \"productId\":\"A00001\", "
                + " \"price\":10.8, "
                + " \"num\":0, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test(expected=JsonValidateException.class)
    public void testValidateFailedForNumberIsOutOfMax() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"100101\" "
                + "}";
        String jsonOrder = "{"
                + " \"productId\":\"A00001\", "
                + " \"price\":10.8, "
                + " \"num\":99, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test(expected=JsonValidateException.class)
    public void testValidateFailedForDateFormatIsInvalid() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"100101\" "
                + "}";
        String jsonOrder = "{"
                + " \"productId\":\"A00001\", "
                + " \"price\":10.8, "
                + " \"num\":9, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015/01/05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test(expected=JsonValidateException.class)
    public void testValidateFailedForAddressIsMissing() throws Exception {
        String jsonOrder = "{"
                + " \"productId\":\"A00001\", "
                + " \"price\":10.8, "
                + " \"num\":9, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\" "
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        ProductOrder order = js.parse(ProductOrder.class);
        assertEquals("A00001", order.productId);
    }

    @Test
    public void testValidateFailedForTimeFormatIsInvalid() throws Exception {
        String jsonAddress = "{"
                + " \"name\":\"Bob\", "
                + " \"address\":\"No.123\", "
                + " \"zipcode\":\"A00101\" "
                + "}";
        String jsonOrder = "{"
                + " \"productId\":\"A00001\", "
                + " \"price\":10.8, "
                + " \"num\":9, "
                + " \"discount\":1.2, "
                + " \"deliverDate\": \"2015-01-05\", "
                + " \"deliverTime\": \"12:20\", "
                + " \"address\": " + jsonAddress
                + "}";
        JsonReader js = new JsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateTypeAdapter())
                .registerTypeAdapter(LocalTime.class, new TimeTypeAdapter())
                .createReader(jsonOrder);
        try {
            js.parse(ProductOrder.class);
            fail("Not caught ValidateException.");
        }
        catch (JsonValidateException e) {
            assertEquals("Format", e.getCode());
            assertEquals("ProductOrder.address.zipcode", e.getPath());
        }
    }

}

class ProductOrder {
    @Required
    @Format(Hex.class)
    @MinLength(1)
    @MaxLength(10)
    String productId;

    @Required
    @MinimumNumber(0.0)
    @MaximumNumber(100.0)
    float price;

    @Required
    @MinimumInteger(0)
    @MaximumInteger(10)
    @ExclusiveMinimum
    int num;

    @MinimumNumber(0.0)
    @MaximumNumber(100.0)
    float discount;

    @Required
    @Pattern("^20[0-9]{2}-[0-9]{2}-[0-9]{2}$")
    LocalDate deliverDate;

    @Pattern("^[0-9]{2}:[0-9]{2}$")
    LocalTime deliverTime;

    @Required
    ShipAddress address;

    @UniqueItems
    List<String> tags;
}

class ShipAddress {
    @Required
    @MinLength(1)
    @MaxLength(10)
    String name;

    @Required
    @MinLength(1)
    @MaxLength(100)
    String address;

    @Required
    @MinLength(6)
    @MaxLength(6)
    @Format(Numeric.class)
    String zipcode;
}
