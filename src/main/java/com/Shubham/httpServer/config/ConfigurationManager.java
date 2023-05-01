package com.Shubham.httpServer.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.Shubham.httpServer.Util.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class ConfigurationManager {
	
	private static ConfigurationManager myConfigurationManager;
	
	private static Configuration myCurrentConfiguration;
	
	
	
	
	
	private ConfigurationManager() {
	
		// TODO Auto-generated constructor stub
	}

	
	public static ConfigurationManager getInstance() {
		if(myConfigurationManager == null)
		{
			return myConfigurationManager = new ConfigurationManager();
		}
		
		return 	myConfigurationManager;
		
	}
	
	/*
	 * 
	 * Used to load Config File by path provided
	 * */

	public void loadConfigurationFile(String filepath) {
		
		try {
			FileReader fileReader = new FileReader(filepath);
			StringBuffer sb = new StringBuffer();
			int i;
			while((i = fileReader.read()) != -1)
			{
				sb.append((char)i);
			}
			
			JsonNode config = Json.parse(sb.toString());
			myCurrentConfiguration = Json.JsonToObject(config,Configuration.class);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new HttpConfigurationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 * Return to  Config File by path provided
	 * */
	
	public Configuration getCurrentConfig() {
		if(myCurrentConfiguration == null) {
			throw new HttpConfigurationException("No Current Config Has Been Set");
		}
		return myCurrentConfiguration;
	}
}
