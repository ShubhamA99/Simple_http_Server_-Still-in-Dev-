package com.Shubham.httpServer.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnectionWorkerThread  extends Thread{

	private Socket socket;
	
	public HttpConnectionWorkerThread (Socket socket) {
		this.socket = socket;
	}

	
	

	private static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
	
	
	
	@Override
	public void run() {
		InputStream inputstream = null;
		OutputStream outputstream = null;
		try {
		 inputstream = socket.getInputStream();
		 outputstream = socket.getOutputStream();
		 
		
		String htmlPage = "<html> "
				+ "   <head> "
				+ "   </head>  "
				+ "   <title>  "
				+ "  	Simple Java http Server "
				+ "   </title> "
				+ "   <body>  "
				+ "    <h1> This Page was Serverd using Simple java Http Server  </h1>         "
				+ "   </body> "
				+ "   </html>";
		
		
		//CR - Carriage Return || LF - Line Feed
		final String CRLF = "\n\r";  // \n-13  \r-10   Ascii Value
		
		
		String response =
				"HTTP/1.1 200 OK "+ CRLF  //Status Line :Http_Version response_code response_Meassage 
				+" Content-length : "+ htmlPage.getBytes().length +CRLF
				+ CRLF 
				+ htmlPage 
				+ CRLF + CRLF;
		
		
		
		outputstream.write(response.getBytes());
		
		LOGGER.info("processing finished");
		
		
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(inputstream != null && outputstream != null  && socket != null) 
			{
			try{
			inputstream.close();
			outputstream.close();
			socket.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		}
		
	}
}
