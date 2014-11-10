package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;

import com.Hotelsoft.DatabaseConnection.GetDepartments;
import com.Hotelsoft.DatabaseConnection.GetGroups;

public class GroupItems {
	GetGroups depart = new GetGroups();
	
	public ArrayList getGroupList(){
		return depart.returnGroupList();
	}
}
