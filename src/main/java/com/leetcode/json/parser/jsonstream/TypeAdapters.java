package com.leetcode.json.parser.jsonstream;

import java.util.HashMap;
import java.util.Map;

/**
 * Store a class-TypeAdapter map.
 * 
 * @author Michael Liao
 */
public class TypeAdapters {

    Map<String, TypeAdapter<?>> adapters = new HashMap<String, TypeAdapter<?>>();

    public <T> void registerTypeAdapter(Class<T> clazz, TypeAdapter<T> typeAdapter) {
        adapters.put(clazz.getName(), typeAdapter);
    }

    /**
     * Get TypeAdapter by class, or null if not found.
     * 
     * @param clazz Class object.
     * @return TypeAdapter or null if not found.
     */
    TypeAdapter<?> getTypeAdapter(Class<?> clazz) {
        return (TypeAdapter<?>) adapters.get(clazz.getName());
    }

}
