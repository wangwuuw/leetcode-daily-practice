package com.leetcode.json.parser.jsonstream.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.MaximumNumber;
import com.leetcode.json.parser.jsonstream.annotation.MinimumNumber;
import com.leetcode.json.parser.jsonstream.annotation.Required;
import com.leetcode.json.parser.jsonstream.validator.Validator;

import java.lang.reflect.AnnotatedElement;


/**
 * A NumberValidator accepts the following annotations:
 * 
 * <ul>
 *   <li>@Required</li>
 *   <li>@MinimumNumber</li>
 *   <li>@MaximumNumber</li>
 * </ul>
 * 
 * @author Michael Liao
 */
public class NumberValidator implements Validator<Double> {

	final boolean required;
	final Double minimum;
	final Double maximum;

	public NumberValidator(AnnotatedElement ae) {
		required = ae.isAnnotationPresent(Required.class);
		minimum = ae.isAnnotationPresent(MinimumNumber.class)
		        ? ae.getAnnotation(MinimumNumber.class).value() : null;
		maximum = ae.isAnnotationPresent(MaximumNumber.class)
		        ? ae.getAnnotation(MaximumNumber.class).value() : null;
	}

	public void validate(Double obj, String path, String name) {
		String fullpath = path + "." + name;
		if (required && obj == null) {
			throw new JsonValidateException("Required", fullpath);
		}
		if (obj == null) {
			return;
		}
		double value = obj.doubleValue();
		if ((minimum != null) && (value < minimum)) {
			throw new JsonValidateException("Minimum", fullpath);
		}
		if ((maximum != null) && (value > maximum)) {
			throw new JsonValidateException("Maximum", fullpath);
		}
	}
}
