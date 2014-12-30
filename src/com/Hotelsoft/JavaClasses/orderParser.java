package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;

import org.json.JSONArray;
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
		//String key;
		System.out.println("inside order parser");
		Orders o = new Orders();


		ArrayList ol = new ArrayList();
		try{
			
		
			JSONArray jsonArray = orderJson.getJSONArray("orderList"); 
			if (jsonArray != null) { 
				int len = jsonArray.length();
				for (int i=0;i<len;i++){ 
					ol.add(jsonArray.get(i).toString());
					}
			} 

		o.setOrderDetail(orderJson.getInt("qty"), orderJson.getString("spclinst"), orderJson.getInt("tableno"), orderJson.getString("orderType"), ol);
		/*Iterator<?> keys = orderJson.keys();
		//HashMap orderMap = new HashMap();
		//while(keys.hasNext()){
			//try{
				
				//orderMap.put(key, value);
				
			//}
			//catch(Exception e){
				//e.printStackTrace();
			//}
		}*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
