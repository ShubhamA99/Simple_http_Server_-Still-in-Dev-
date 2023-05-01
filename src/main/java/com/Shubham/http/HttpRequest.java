package com.Shubham.http;

public class HttpRequest extends HttpMessage {
	
	private HttpMethod method;
	private String requestTarget;
	private String httpVersion;
	
	public HttpRequest(HttpMethod method, String requestTarget, String httpVersion) {
		super();
		this.method = method;
		this.requestTarget = requestTarget;
		this.httpVersion = httpVersion;
	}

	public HttpRequest() {
	
	}

	public HttpMethod getMethod() {
		return method;
	}
	

	public void setMethod(String method) throws HttpParsingException {		
		for(HttpMethod m : HttpMethod.values()) {
			if(method.equals(m.name()))
			{
				this.method = HttpMethod.valueOf(method);
				return;
			}
		}
		
		throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_501_NOT_IMPLEMENTED);
	}

	public String getRequestTarget() {
		return requestTarget;
	}

	public void setRequestTarget(String requestTarget) {
		this.requestTarget = requestTarget;
	}

	public String getHttpVersion() {
		return httpVersion;
	}

	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}
	
	
	

}
