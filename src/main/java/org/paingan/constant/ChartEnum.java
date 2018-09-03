package org.paingan.constant;

public enum ChartEnum {
	DEVICE_IOS 		(0, "ios"),
	DEVICE_ANDROID 	(1, "android"),
	
	PAGE_MAIN (2, "main"),
	PAGE_PDP (3 ,"pdp"),
	PAGE_SEARCH (4, "search"),
	PAGE_CATEGORY (5, "category");
	

	private final int key;
	private final String value;

	ChartEnum(int key, String value) {
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
