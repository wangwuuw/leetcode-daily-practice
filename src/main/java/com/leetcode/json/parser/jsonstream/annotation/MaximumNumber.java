package com.leetcode.json.parser.jsonstream.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The maximum allowed number.
 * 
 * @author Michael Liao
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaximumNumber {

	double value();

}