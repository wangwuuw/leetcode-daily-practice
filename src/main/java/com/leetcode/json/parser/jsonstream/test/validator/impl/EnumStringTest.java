package com.leetcode.json.parser.jsonstream.test.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.EnumString;
import com.leetcode.json.parser.jsonstream.validator.impl.StringValidator;
import org.junit.Before;
import org.junit.Test;


public class EnumStringTest {

	StringValidator enumValidator;
	EnumStringBean bean;

	@Before
	public void setUp() throws Exception {
		enumValidator = new StringValidator(EnumStringBean.class.getDeclaredField("enumValue"));
		bean = new EnumStringBean();
	}

	@Test
	public void testContainsEnumValue() {
		enumValidator.validate(".org", "path", "value");
	}

	@Test(expected= JsonValidateException.class)
	public void testNotContainsEnumValue() {
		enumValidator.validate(".gov", "path", "value");
	}

	@Test
	public void testEnumValueIsNull() {
		enumValidator.validate(null, "path", "value");
	}

}

class EnumStringBean {

	@EnumString({ ".edu", ".com", ".net", ".org" })
	String enumValue;

}
