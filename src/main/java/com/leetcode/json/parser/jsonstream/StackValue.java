package com.leetcode.json.parser.jsonstream;

import java.util.List;
import java.util.Map;

/**
 * Value object to push and pop in stack when parsing JSON.
 * 
 * @author Michael Liao
 */
public class StackValue {

    public static final int TYPE_OBJECT = 0;

    public static final int TYPE_OBJECT_KEY = 1;

    public static final int TYPE_ARRAY = 2;

    public static final int TYPE_SINGLE = 3;

    final int type;
    public final Object value;

    private StackValue(int type, Object value) {
        this.type = type;
        this.value = value;
    }

    static StackValue newJsonObject(Object obj) {
        return new StackValue(TYPE_OBJECT, obj);
    }

    static StackValue newJsonObject(Map<String, Object> map) {
        return new StackValue(TYPE_OBJECT, map);
    }

    static StackValue newJsonObjectKey(String key) {
        return new StackValue(TYPE_OBJECT_KEY, key);
    }

    static StackValue newJsonArray(List<Object> arr) {
        return new StackValue(TYPE_ARRAY, arr);
    }

    public static StackValue newJsonSingle(Object obj) {
        return new StackValue(TYPE_SINGLE, obj);
    }

    String valueAsKey() {
        return (String) value;
    }

    @SuppressWarnings("unchecked")
    Map<String, Object> valueAsObject() {
        return (Map<String, Object>) value;
    }

    @SuppressWarnings("unchecked")
    List<Object> valueAsArray() {
        return (List<Object>) value;
    }
}
