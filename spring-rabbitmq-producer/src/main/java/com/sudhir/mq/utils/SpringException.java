package com.sudhir.mq.utils;
@SuppressWarnings("serial")
public class SpringException extends RuntimeException{

	public SpringException(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public SpringException(boolean status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	private boolean status;
	private String message;
	private Object data;
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
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

	@Override
	public String toString() {
		return "{\"status\":"+ status +", \"message\":\"" + message + "\", \"data\":\""+data+"\"}";
	} 
	
	
//	@Override
//	public String toString() {
//		return "{\"status\":"+ status +", \"message\":\"" + message + "\"}";
//	} 
}