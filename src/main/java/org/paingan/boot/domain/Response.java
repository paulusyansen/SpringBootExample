package org.paingan.boot.domain;

import org.paingan.constant.ResponseEnum;

public class Response {
	private String status = "OK";
	private String message = "";
	private Object data;
	
	public Response() {
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
 
	public Object getData() {
		return data;
	}
 
	public void setData(Object data) {
		this.data = data;
	}
	
	public void setResponse(String status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	public void setStatusOK(){
        this.setStatus(ResponseEnum.OK.getValue());
    }
	
    public void setStatusFail(){
        this.setStatus(ResponseEnum.FAIL.getValue());
    }
}
