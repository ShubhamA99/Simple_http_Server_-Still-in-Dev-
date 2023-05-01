package com.Shubham.httpServer.config;

public class Configuration {

	
	private int port;
	
	private String webroot;
	
	

	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Configuration(int port, String webroot) {
		super();
		port = port;
		webroot = webroot;
	}

	public int getPORT() {
		return port;
	}

	public void setPORT(int pORT) {
		port = pORT;
	}

	public String getWEBROOT() {
		return webroot;
	}

	public void setWEBROOT(String wEBROOT) {
		webroot = wEBROOT;
	}

	@Override
	public String toString() {
		return "Configuration [port=" + port + ", webroot=" + webroot + "]";
	}
}
