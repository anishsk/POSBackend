package com.Hotelsoft.DatabaseConnection;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class ValidateUser extends ConnectionManager {
	private String UserName,UserPass;
	private Statement st = null;
	private ResultSet rs = null;
	
	public ValidateUser(String uname,String upass) {
		// TODO Auto-generated constructor stub
		connection = super.getConnection();
		UserName=uname;
		UserPass=upass;
		try{
			st = (Statement)connection.createStatement();
			rs = (ResultSet)st.executeQuery("select userpwd from employee where username = '"+ UserName + "';");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	
	}
	public int checkValid(){
		try{
			if(rs.next())
				if(UserPass.equals(rs.getString(1)))
					return 1;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
}
