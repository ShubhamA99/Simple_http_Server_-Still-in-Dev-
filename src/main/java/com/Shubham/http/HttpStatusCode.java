package com.Shubham.http;

public enum HttpStatusCode {

	
	CLIENT_ERROR_400_BAD_REQUEST("Bad Request",400),
	CLIENT_ERROR_401_METHOD_NOT_ALLOWED("Method not Allowed",401),
	CLIENT_ERROR_414_URI_TOo_LONG("URI Too Long",414),
	SERVER_ERROR_500_INTERNAL_SERVER_ERROR("Internal Server Error",500),
	SERVER_ERROR_501_NOT_IMPLEMENTED("not Implemented",501);
	
	
	public  final String message;
	public  final int Status_code;
	
	
	 HttpStatusCode(String message, int status_code) {
		this.message = message;
		this.Status_code = status_code;
	}
	
	
	
	
}
