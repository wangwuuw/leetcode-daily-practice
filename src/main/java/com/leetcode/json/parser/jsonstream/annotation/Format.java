package com.leetcode.json.parser.jsonstream.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.leetcode.json.parser.jsonstream.format.StringFormat;

/**
 * Specify a FormatClass to validate a string value.
 * 
 * @author Michael Liao
 */
@Repeatable(Formats.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {

	Class<? extends StringFormat> value();

}
