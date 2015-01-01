package com.Hotelsoft.JavaClasses;

import java.util.HashMap;

import org.json.JSONObject;

public class JsonAggregator {

	@SuppressWarnings({"unchecked","rawtypes"})
	public JSONObject getAllJson() {
		// JsonMap.clear();
		JSONObject aggregatedJson = null;
		HashMap JsonMap = new HashMap();
		MenuItems menureturn = new MenuItems();
		DepartmentItems deptitm = new DepartmentItems();
		GroupItems groupreturn = new GroupItems();
		JsonMap.put("department", deptitm.getDepartmentList());
		JsonMap.put("groups", groupreturn.getGroupList());
		JsonMap.put("menu", menureturn.getMenu());
		aggregatedJson = new JSONObject(JsonMap);
		System.out.println(aggregatedJson.toString());
		return aggregatedJson;
	}

}
