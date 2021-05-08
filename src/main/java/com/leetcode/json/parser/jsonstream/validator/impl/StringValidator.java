package com.leetcode.json.parser.jsonstream.validator.impl;

import com.leetcode.json.parser.jsonstream.JsonValidateException;
import com.leetcode.json.parser.jsonstream.annotation.EnumString;
import com.leetcode.json.parser.jsonstream.annotation.Format;
import com.leetcode.json.parser.jsonstream.annotation.MaxLength;
import com.leetcode.json.parser.jsonstream.annotation.MinLength;
import com.leetcode.json.parser.jsonstream.annotation.Pattern;
import com.leetcode.json.parser.jsonstream.annotation.Required;
import com.leetcode.json.parser.jsonstream.format.StringFormat;
import com.leetcode.json.parser.jsonstream.validator.Validator;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * A StringValidator accepts the following annotations:
 * 
 * <ul>
 *   <li>@Required</li>
 *   <li>@MinLength</li>
 *   <li>@MaxLength</li>
 *   <li>@Pattern</li>
 *   <li>@EnumString</li>
 *   <li>@Format</li>
 * </ul>
 * 
 * @author Michael Liao
 */
public class StringValidator implements Validator<String> {

	final boolean required;
	final Integer minLength;
	final Integer maxLength;
	final java.util.regex.Pattern pattern;
	final Set<String> enums;
	final StringFormat[] formats;

    public StringValidator(AnnotatedElement ae) {
        required = ae.isAnnotationPresent(Required.class);
        minLength = ae.isAnnotationPresent(MinLength.class)
                ? ae.getAnnotation(MinLength.class).value() : null;
        maxLength = ae.isAnnotationPresent(MaxLength.class)
                ? ae.getAnnotation(MaxLength.class).value() : null;
        pattern = ae.isAnnotationPresent(Pattern.class)
                ? java.util.regex.Pattern.compile(ae.getAnnotation(Pattern.class).value()) : null;
        enums = ae.isAnnotationPresent(EnumString.class)
                ? new HashSet<String>(Arrays.asList(ae.getAnnotation(EnumString.class).value())) : null;
        Format[] formatAnnos = ae.getAnnotationsByType(Format.class);
        formats = new StringFormat[formatAnnos.length];
        for (int i=0; i<formatAnnos.length; i++) {
            formats[i] = newStringFormat(formatAnnos[i].value());
        }
    }

	StringFormat newStringFormat(Class<? extends StringFormat> clazz) {
	    try {
            return clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
	}

	public void validate(String obj, String path, String name) {
		String fullpath = path + "." + name;
		if (required && obj == null) {
			throw new JsonValidateException("Required", fullpath);
		}
		if (obj == null) {
			return;
		}
		if ((minLength != null) && (obj.length() < minLength)) {
			throw new JsonValidateException("MinLength", fullpath);
		}
		if ((maxLength != null) && (obj.length() > maxLength)) {
			throw new JsonValidateException("MaxLength", fullpath);
		}
		if ((pattern != null) && !pattern.matcher(obj).matches()) {
			throw new JsonValidateException("Pattern", fullpath);
		}
		if (enums != null && !enums.contains(obj)) {
			throw new JsonValidateException("Enum", fullpath);
		}
		for (StringFormat sf : formats) {
		    if (! sf.validate(obj)) {
		        throw new JsonValidateException("Format", fullpath);
		    }
		}
	}

}
