package com.Shubham.httpServer.Util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {

	private static ObjectMapper myObjectMapper = defaultObjectMapper() ;
	
	
	private static ObjectMapper defaultObjectMapper() {
		
		ObjectMapper OM = new ObjectMapper();
		OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		return OM;
	}
	
	
	public  static JsonNode parse(String jsonSrc) throws IOException {
		
		return myObjectMapper.readTree(jsonSrc);
	}
	
	
	public static <O> O JsonToObject(JsonNode node, Class<O> clazz  ) throws JsonProcessingException {
		return myObjectMapper.treeToValue(node, clazz);
	}
	
	
	public static JsonNode ObjectToJSon(Object obj) {
		return myObjectMapper.valueToTree(obj);
	}
	
	private static String JsonNodePrintable(Object obj,boolean formatting ) throws JsonProcessingException {
		ObjectWriter objwriter =  myObjectMapper.writer();
		if(formatting) {
			objwriter = objwriter.with(SerializationFeature.INDENT_OUTPUT);
		}
		return objwriter.writeValueAsString(obj);
	}
	
	public static String JsonNodetoString(JsonNode node , boolean formatting) throws JsonProcessingException {
		
		if(formatting) {
			return JsonNodePrintable(node,true);
		}
		
		return JsonNodePrintable(node,false);
	}
	
}
