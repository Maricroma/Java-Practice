package com.informatorioblog.blog.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {
	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("uri")
	private String uriRequested;
	
	
	public ErrorMessage(String message, int statusCode, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public String getMessage() {
		return message;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public String getUriRequested() {
		return uriRequested;
	}
	
	
	
}
