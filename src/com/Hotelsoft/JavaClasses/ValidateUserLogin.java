/*
 * this class is used to validate the user login information entered from the 
 * android client.
 * lookup through the employee table to match the username and password combination posted 
 * by the client
 */


package com.Hotelsoft.JavaClasses;

import com.Hotelsoft.DatabaseConnection.ValidateUser;

public class ValidateUserLogin{
	private ValidateUser vu;
	public ValidateUserLogin(String uname,String upass) {
		// TODO Auto-generated constructor stub
		vu = new ValidateUser(uname, upass);
	}
	public int checkIfValiduser(){
		return vu.checkValid();
	}
	
	
}
