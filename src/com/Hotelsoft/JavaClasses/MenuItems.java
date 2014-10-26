package com.Hotelsoft.JavaClasses;

import java.util.HashMap;

import com.Hotelsoft.DatabaseConnection.GetMenu;

public class MenuItems {

	public HashMap getMenuItems(){
		GetMenu menu = new GetMenu();
		return menu.returnMenu();
	}
}
