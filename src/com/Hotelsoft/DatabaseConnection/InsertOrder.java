//how to parse kotno in insertorder
package com.Hotelsoft.DatabaseConnection;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public class InsertOrder extends ConnectionManager {
	private PreparedStatement st = null;
	private String sql = "INSERT INTO kot("
	        + "posno,"
	        + "kotno,"
	        + "auditdate,"
	        + "tableno,"
	        + "qty,"
	        + "itemtypeno,"
	        + "kottime)"
	        +  "VALUES(?,?,?,?,?,?,?)";
	//private ResultSetImpl rs = null;
	
	
	public InsertOrder() {
		connection = super.getConnection();
		try{
			st = (PreparedStatement)connection.prepareStatement(sql);
			System.out.println("in insertorder");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	void insertOrdersinDB(){
		try {

			// Set the values
			st.setInt(1, 1);
		    st.setString(2, "firstString");
		    st.setString(2, "secondString");

		    // Insert 
		    st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try{
				st.close();
				connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	private String generateKot(){
		String kotno=null;
		LocalDate dt = new LocalDate();
		LocalTime tm = new LocalTime();
		DateTimeFormatter frm = DateTimeFormat.forPattern("HH:mm:ss");
		connection = super.getConnection();
		try{
			System.out.println("inside kotgenerator "+dt+"\n\n"+tm);
			Statement st = (Statement) connection.createStatement();
			ResultSetImpl rs = (ResultSetImpl) st.executeQuery("select kotno from kot where auditdate<'"+dt + "'& kottime<"+"'"+frm.print(tm)+"'");
			System.out.println("inside kotgenerator "+dt+"\n\n"+tm);
			rs.afterLast();
			rs.previous();
			kotno=rs.getString("kotno");
		}
		//how to parse and increment kotno??
		catch(Exception e){
			e.printStackTrace();
		}
		return kotno;
	}
}
