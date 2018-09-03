package org.paingan.constant;

public enum ResponseEnum {
	OK 		(1, "OK"),
	FAIL 	(0, "FAIL");

	private final int key;
	private final String value;

	ResponseEnum(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
}
