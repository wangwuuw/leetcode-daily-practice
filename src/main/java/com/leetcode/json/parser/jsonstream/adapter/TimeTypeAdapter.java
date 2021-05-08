package com.leetcode.json.parser.jsonstream.adapter;

import com.leetcode.json.parser.jsonstream.TypeAdapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * Standard Time type adapter for conversion between String and LocalTime.
 * 
 * @author Michael Liao
 */
public class TimeTypeAdapter implements TypeAdapter<LocalTime> {

    DateTimeFormatter formatter;

    public TimeTypeAdapter() {
        this.formatter = DateTimeFormatter.ISO_LOCAL_TIME;
    }

    public TimeTypeAdapter(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    public TimeTypeAdapter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LocalTime deserialize(String s) {
        return LocalTime.parse(s, this.formatter);
    }

    @Override
    public String serialize(LocalTime t) {
        return t.format(this.formatter);
    }

}
