package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;


import org.json.JSONArray;
import org.json.JSONObject;

import com.Hotelsoft.DatabaseConnection.InsertOrder;

public class orderParser {
	
	private JSONObject orderJson;
	
	public orderParser(){
		orderJson=null;
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
		OrderItem OrderItemHolder = null;
		ArrayList OrderList = new ArrayList();
		try{
			JSONArray itemArray = orderJson.getJSONArray("orderitems"); 
			if (itemArray != null) { 
				int len = itemArray.length();
				for (int i=0;i<len;i++){
					OrderItemHolder = new OrderItem();
					JSONObject temp = (JSONObject)itemArray.get(i);
					OrderItemHolder.setOrderItemName(temp.getString("menuitemname"));
					OrderItemHolder.setItemType(temp.getString("menuitemtype"));
					OrderItemHolder.setQuantity(temp.getInt("qty"));
					OrderItemHolder.setSpclInst(temp.getString("spclinst"));
					OrderItemHolder.setTableNo(orderJson.getInt("tableno"));//kept table number a part of individual orderlist item because it will be easy to insert in DB
					OrderList.add(OrderItemHolder);
					}
			}
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
		InsertOrder OrderToInsert = new InsertOrder();
		OrderToInsert.insertOrdersinDB(OrderList);
	}

}