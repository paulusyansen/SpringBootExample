package org.paingan.constant;

public enum HTTPResponse {
	SUCCESS(200), RESOURCE_NOT_FOUND(404), BAD_REQUEST(201), UNAUTHORIZED(401), UNSUPPORTED_TYPE(415), SERVER_ERROR(500);
	
	private final int code;
	
	HTTPResponse(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
