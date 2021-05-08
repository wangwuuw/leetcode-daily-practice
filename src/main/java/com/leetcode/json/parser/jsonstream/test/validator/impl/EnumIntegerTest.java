package com.leetcode.json.parser.jsonstream.test.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.EnumInteger;
import com.leetcode.json.parser.jsonstream.validator.impl.IntegerValidator;
import org.junit.Before;
import org.junit.Test;


public class EnumIntegerTest {

	IntegerValidator enumValidator;
	EnumIntegerBean bean;

	@Before
	public void setUp() throws Exception {
		enumValidator = new IntegerValidator(EnumIntegerBean.class.getDeclaredField("enumValue"));
		bean = new EnumIntegerBean();
	}

	@Test
	public void testContainsEnumValue() {
		enumValidator.validate(35L, "path", "value");
	}

	@Test(expected= JsonValidateException.class)
	public void testNotContainsEnumValue() {
		enumValidator.validate(11L, "path", "value");
	}

	@Test
	public void testEnumValueIsNull() {
		enumValidator.validate(null, "path", "value");
	}

}

class EnumIntegerBean {

	@EnumInteger({ 15, 25, 35, 45 })
	Long enumValue;

}
