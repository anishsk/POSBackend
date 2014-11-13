package com.Hotelsoft.DatabaseConnection;

/*
 * import java.io.FileInputStream;
 * import java.io.InputStream;
 */
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;*/


import java.util.Properties;

import com.mysql.jdbc.Connection;
/*import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;*/

public class ConnectionManager {

	public Connection connection = null;
	private static String dbUser = null;
	private static String dbPassword = null;
	private static String dbURL = null;
	private static String dbDriver = null;
	

	public Connection getConnection() {
		/*
		 * Function to create connection to database 
		 */
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			dbUser = prop.getProperty("jdbc.username");
			dbPassword = prop.getProperty("jdbc.password");
			dbURL = prop.getProperty("jdbc.url");
			dbDriver = prop.getProperty("jdbc.driver");
			Class.forName(dbDriver).newInstance();
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = (Connection) DriverManager.getConnection(dbURL, dbUser, dbPassword);
			//connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/alive", "root", "anishkumar");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connection Successful");

		return connection;
	}
}
