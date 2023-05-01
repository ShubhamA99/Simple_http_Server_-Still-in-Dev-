package com.Shubham.httpServer.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Shubham.httpServer.httpServer;

public class ServerListenerThread extends Thread {
	
	
	private static Logger LOGGER = LoggerFactory.getLogger(ServerListenerThread.class);
	
	
	
	private int port;
	private String webroot;
	private ServerSocket serverSocket;
	
	public ServerListenerThread(int port, String webroot) {
		super();
		this.port = port;
		this.webroot = webroot;
		 try {
			this.serverSocket= new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}






	@Override
	public void run() {
		try {
			
			while(serverSocket.isBound() && !serverSocket.isClosed()) {
			Socket socket = serverSocket.accept();
			
			LOGGER.info(" Connection accept"+ socket.getInetAddress() );
			
			HttpConnectionWorkerThread hcwt = new HttpConnectionWorkerThread(socket);
			hcwt.start();
			
			}
			//serverSocket.close();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
