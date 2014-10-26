package com.Hotelsoft.JavaClasses;

import java.util.HashMap;

import org.json.JSONObject;

public class JsonAggregator {

	private JSONObject aggregatedJson = null;
	private HashMap JsonMap = new HashMap();
	private MenuItems menureturn = new MenuItems();
	
	public JSONObject getAllJsonFromHashes(){
		JsonMap.put("department", menureturn.getMenuItems());
		aggregatedJson = new JSONObject(JsonMap);
		return aggregatedJson;
	}
	
}
