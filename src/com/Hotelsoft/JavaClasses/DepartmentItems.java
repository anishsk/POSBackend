package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;

import com.Hotelsoft.DatabaseConnection.GetDepartments;

public class DepartmentItems {
	GetDepartments depart = new GetDepartments();
	
	public ArrayList getDepartmentList(){
		return depart.returnDepartments();
	}
}
