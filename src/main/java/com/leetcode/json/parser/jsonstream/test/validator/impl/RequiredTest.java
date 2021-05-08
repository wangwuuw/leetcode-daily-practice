package com.leetcode.json.parser.jsonstream.test.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.Required;
import com.leetcode.json.parser.jsonstream.validator.impl.IntegerValidator;
import com.leetcode.json.parser.jsonstream.validator.impl.NumberValidator;
import com.leetcode.json.parser.jsonstream.validator.impl.StringValidator;
import org.junit.Before;
import org.junit.Test;


public class RequiredTest {

	IntegerValidator integerValidator;
	NumberValidator numberValidator;
	StringValidator stringValidator;
	RequiredBean bean;

	@Before
	public void setUp() throws Exception {
		integerValidator = new IntegerValidator(RequiredBean.class.getDeclaredField("requiredLong"));
		numberValidator = new NumberValidator(RequiredBean.class.getDeclaredField("notRequiredDouble"));
		stringValidator = new StringValidator(RequiredBean.class.getDeclaredField("requiredString"));
		bean = new RequiredBean();
	}

	@Test
	public void testRequiredLong() {
		integerValidator.validate(1L, "path", "value");
	}

	@Test(expected= JsonValidateException.class)
	public void testRequiredLongButNull() {
		integerValidator.validate(null, "path", "value");
	}

	@Test
	public void testNotRequiredDouble() {
		numberValidator.validate(1.23, "path", "value");
	}

	@Test
	public void testNotRequiredDoubleAndNull() {
		numberValidator.validate(null, "path", "value");
	}

	@Test
	public void testRequiredString() {
		stringValidator.validate("", "path", "value");
	}

	@Test(expected=JsonValidateException.class)
	public void testRequiredStringButNull() {
		stringValidator.validate(null, "path", "value");
	}

}

class RequiredBean {

	@Required
	Long requiredLong;

	Double notRequiredDouble;

	@Required
	String requiredString;
}
