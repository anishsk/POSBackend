package com.Hotelsoft.TestClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.Hotelsoft.DatabaseConnection.ConnectionManager;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;


public class DateTime extends ConnectionManager {

	public static void main(String[] args) {
		try{
		// TODO Auto-generated method stub
		LocalDate dt = new LocalDate();
	    LocalTime tm = new LocalTime();
	    DateTimeFormatter frm = DateTimeFormat.forPattern("HH:mm:ss");
	    
	    System.out.println(dt);
	    System.out.println(frm.print(tm));
	    ConnectionManager c = new ConnectionManager();
	    c.connection=c.getConnection();
	    Statement st = (Statement) c.connection.createStatement();
		ResultSetImpl rs = (ResultSetImpl) st.executeQuery("select kotno from kot where auditdate<'"+dt + "'& kottime<"+"'"+frm.print(tm)+"'");
		while(rs.next()){
			
			System.out.println(rs.getString("kotno"));
		}
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getString("kotno"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	    
	}

}
