package com.Shubham.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Shubham.httpServer.core.HttpConnectionWorkerThread;

public class HttpParser {
	
	private static Logger LOGGER = LoggerFactory.getLogger(HttpParser.class);
	
	private static final int SP = 0x20;
	private static final int CR = 0x0D;
	private static final int LF = 0x0A;
	
	
	public HttpRequest parsehttpReq(InputStream input) throws HttpParsingException {
		
		InputStreamReader reader = new InputStreamReader(input,StandardCharsets.US_ASCII);
		HttpRequest request = new HttpRequest();
		
		try {
			parseRequestLine(reader,request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parseHeaders(reader,request);
		parseBody(reader,request);
		
		
		return request;
		
	}
	
	private void parseRequestLine(InputStreamReader reader, HttpRequest request) throws IOException, HttpParsingException {
		int _byte;
		StringBuilder processingDataBuffer = new StringBuilder();
		
		boolean methodParsed = false;
		boolean requestTargetParsed = false;
		
		while((_byte =reader.read()) >= 0) {
			if(_byte == CR) {
				_byte = reader.read();
		
				if(_byte == LF) {
					
					LOGGER.info("\"Request Line Version to Process :{}\"",processingDataBuffer.toString());
					
					return ;
				}
			}
			
			
			if(_byte == SP) {
				if(!methodParsed)
				{
					LOGGER.info("Request Line Method to Process :{}", processingDataBuffer.toString());
					request.setMethod(processingDataBuffer.toString());
					methodParsed= true;
				}
				else if(!requestTargetParsed)
				{
					LOGGER.info("Request Line Target to Process :{}", processingDataBuffer.toString());
					requestTargetParsed= true;
				}
				
				processingDataBuffer.delete(0, processingDataBuffer.length());
			}else {
				processingDataBuffer.append((char)_byte);
				if(!methodParsed)
				{
					if(processingDataBuffer.length() > HttpMethod.MAX_LENGTH)
					{
						throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_501_NOT_IMPLEMENTED);
					}
				}
			}
		}
		
		
		
		
	}

	private void parseHeaders(InputStreamReader reader, HttpRequest request) {
		// TODO Auto-generated method stub
		
	}

	private void parseBody(InputStreamReader reader, HttpRequest request) {
		// TODO Auto-generated method stub
		
	}




	

}
