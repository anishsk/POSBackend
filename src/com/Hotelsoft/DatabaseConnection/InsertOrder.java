package com.Hotelsoft.DatabaseConnection;

import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;

@SuppressWarnings("unused")
public class InsertOrder extends ConnectionManager {
	private Statement st = null;
	
	private ResultSetImpl rs = null;
	
	
	public InsertOrder() {
		connection = super.getConnection();
		try{
			st = (Statement)connection.createStatement();
			System.out.println("in insertorder");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
