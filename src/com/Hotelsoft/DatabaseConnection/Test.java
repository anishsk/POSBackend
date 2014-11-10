package com.Hotelsoft.DatabaseConnection;

import com.Hotelsoft.JavaClasses.JsonAggregator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		/*GetDepartments men = new GetDepartments();
		GetMenu items = new GetMenu();
		GetGroups groups = new GetGroups();
		men.returnDepartments();
		items.returnMenuItems();
		groups.returnGroupList();*/
		for (int i = 0 ; i<5; i++)
		{
		JsonAggregator j = new JsonAggregator();
		j.getAllJson();
	}
	}

}
