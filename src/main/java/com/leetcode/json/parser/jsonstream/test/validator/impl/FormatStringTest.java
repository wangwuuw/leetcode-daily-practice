package com.leetcode.json.parser.jsonstream.test.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.Format;
import com.leetcode.json.parser.jsonstream.format.Email;
import com.leetcode.json.parser.jsonstream.format.LowerCase;
import com.leetcode.json.parser.jsonstream.validator.impl.StringValidator;
import org.junit.Before;
import org.junit.Test;


public class FormatStringTest {

	StringValidator formatValidator;
	FormatStringBean bean;

	@Before
	public void setUp() throws Exception {
		formatValidator = new StringValidator(FormatStringBean.class.getDeclaredField("emailValue"));
		bean = new FormatStringBean();
	}

    @Test
    public void testEmailIsOk() {
        formatValidator.validate("michael@itranswarp.com", "path", "value");
    }

	@Test(expected= JsonValidateException.class)
    public void testEmailIsOkButLowerCaseFailed() {
        formatValidator.validate("Michael@itranswarp.com", "path", "value");
    }

	@Test
	public void testEmailValueIsNull() {
	    formatValidator.validate(null, "path", "value");
	}

}

class FormatStringBean {

    @Format(Email.class)
	@Format(LowerCase.class)
	String emailValue;

}
