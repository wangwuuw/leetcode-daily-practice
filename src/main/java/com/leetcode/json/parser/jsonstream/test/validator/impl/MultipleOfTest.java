package com.leetcode.json.parser.jsonstream.test.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.MultipleOf;
import com.leetcode.json.parser.jsonstream.validator.impl.IntegerValidator;
import org.junit.Before;
import org.junit.Test;


public class MultipleOfTest {

	IntegerValidator multipleOfValidator;
	IntegerValidator anyOfValidator;
	MultipleOfBean bean;

	@Before
	public void setUp() throws Exception {
		multipleOfValidator = new IntegerValidator(MultipleOfBean.class.getDeclaredField("multipleOf"));
		anyOfValidator = new IntegerValidator(MultipleOfBean.class.getDeclaredField("anyOf"));
		bean = new MultipleOfBean();
	}

	@Test
	public void testMultipleOf10() {
		multipleOfValidator.validate(50L, "path", "value");
	}

	@Test
	public void testMultipleOfIsNull() {
		multipleOfValidator.validate(null, "path", "value");
	}

	@Test(expected= JsonValidateException.class)
	public void testNotMultipleOf10() {
		multipleOfValidator.validate(55L, "path", "value");
	}

	@Test
	public void testAnyOf() {
		anyOfValidator.validate(99L, "path", "value");
	}

	@Test
	public void testAnyOfNull() {
		anyOfValidator.validate(null, "path", "value");
	}

}

class MultipleOfBean {

	@MultipleOf(10)
	long multipleOf;

	long anyOf;

}
