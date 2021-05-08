package com.leetcode.json.parser.jsonstream;

/**
 * Exception when serialize to JSON.
 * 
 * @author Michael Liao
 */
public class JsonSerializeException extends JsonException {

    /**
     * Construct a JsonSerializeException.
     * 
     * @param message The exception message.
     */
    public JsonSerializeException(String message) {
        super(message);
    }
}
