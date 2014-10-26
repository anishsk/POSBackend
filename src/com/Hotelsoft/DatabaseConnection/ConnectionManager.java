package com.Hotelsoft.DatabaseConnection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ConnectionManager {
	
	
  public Connection connection = null;
	 static String dbuser = null;
	 static String dbpassword = null;
	 
	 
	 public Connection getConnection ()
	 {
		 
		 //String query = "select * from menuitem";
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alive", "root","");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Connection Successful");
	
			return connection;
	 }
}
