package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;
import java.util.HashMap;

import com.Hotelsoft.DatabaseConnection.*;

public class MenuItems {

	public HashMap getDepartments(){
		GetDepartments menu = new GetDepartments();
		return null;//menu.returnMenu();
	}
	
	
	public HashMap getMenu()
	{
		GetMenu menu = new GetMenu();
		return menu.returnMenuItems();
		
	}
}
