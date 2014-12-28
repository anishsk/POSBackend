package com.Hotelsoft.JavaClasses;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONObject;

public class orderParser {
	
	private JSONObject orderJson;
	
	public orderParser(){
		
	}
	
	public orderParser(String orderString) {
		try{
			System.out.println("Assigning order string to json obj");
			orderJson = new JSONObject(orderString);
			System.out.println(orderJson);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void orderJsonParser() {
		String key;
		System.out.println("inside order parser");
		Iterator<?> keys = orderJson.keys();
		HashMap orderMap = new HashMap();
		while(keys.hasNext()){
			try{
				key = (String)keys.next();
				Object value = orderJson.get(key);
				orderMap.put(key, value);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
