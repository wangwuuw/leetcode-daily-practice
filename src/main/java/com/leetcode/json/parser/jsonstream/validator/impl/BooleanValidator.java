package com.leetcode.json.parser.jsonstream.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.Required;
import com.leetcode.json.parser.jsonstream.validator.Validator;

import java.lang.reflect.AnnotatedElement;

/**
 * A BooleanValidator.
 * 
 * @author Michael Liao
 */
public class BooleanValidator implements Validator<Boolean> {

    final boolean required;

    public BooleanValidator(AnnotatedElement ae) {
        required = ae.isAnnotationPresent(Required.class);
    }

    public void validate(Boolean obj, String path, String name) {
        if (required && obj == null) {
            throw new JsonValidateException("Required", path + "." + name);
        }
	}
}
