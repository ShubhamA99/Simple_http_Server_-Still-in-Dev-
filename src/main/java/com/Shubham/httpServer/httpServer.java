package com.Shubham.httpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Shubham.httpServer.config.Configuration;
import com.Shubham.httpServer.config.ConfigurationManager;
import com.Shubham.httpServer.core.ServerListenerThread;

public class httpServer {

/*
 * Driver Class For Http Server
 * 
 * */
	
	private static Logger LOGGER = LoggerFactory.getLogger(httpServer.class);
	
	public static void main(String[] args) {
	
		LOGGER.info("Server Starting...");
	
		//Setting Up the Configuration for Server (Port,Webroot)
		ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
		Configuration conf = ConfigurationManager.getInstance().getCurrentConfig();
		LOGGER.info(conf.toString());
		
		
		
		ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPORT(), conf.getWEBROOT());
		serverListenerThread.start();
		
		
		
		
		
	}
}
