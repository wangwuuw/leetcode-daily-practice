package com.leetcode.json.parser.jsonstream;

/**
 * ValidateException represent a validation error.
 * 
 * @author Michael Liao
 */
public class JsonValidateException extends JsonException {

	private final String code;
	private final String path;

	public JsonValidateException(String code, String path) {
		super("Validation failed: " + path + ", not satisfied by: " + code);
		this.code = code;
		this.path = path;
	}

	public JsonValidateException(String code, String path, Throwable cause) {
		super("Validation failed: " + path + ", not satisfied by: " + code, cause);
		this.code = code;
		this.path = path;
	}

	public String getCode() {
		return this.code;
	}

	public String getPath() {
		return this.path;
	}
}
