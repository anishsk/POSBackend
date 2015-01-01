//how to parse kotno in insertorder
package com.Hotelsoft.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;

import com.Hotelsoft.JavaClasses.OrderItem;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@SuppressWarnings({"unused","rawtypes"})
public class InsertOrder extends ConnectionManager {
	private LocalDate dt = new LocalDate();
	private LocalTime tm = new LocalTime();
	private DateTimeFormatter frm = DateTimeFormat.forPattern("HH:mm:ss");

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
	
	public void insertOrdersinDB(ArrayList orderlist){
		try {
			st.setInt(1, 1);
			if(orderlist!=null){
				int len=orderlist.size();
				for(int i=0;i<len;i++){
					OrderItem temp = (OrderItem)orderlist.get(i);
				    st.setString(2, generateKot());
				    st.setDate(3,new java.sql.Date(dt.toDate().getTime()));
				    st.setInt(4, temp.getTableNo());
				    st.setInt(5, temp.getQuantity());
				    st.setString(6, temp.getItemType());
				    st.setTime(7, new java.sql.Time(tm.toDateTimeToday().getMillis()));
				    // Insert 
				    st.executeUpdate();
				}
			}
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
				connection = super.getConnection();
		try{
			System.out.println("inside kotgenerator "+dt+"\n\n"+tm);
			Statement st = (Statement) connection.createStatement();
			ResultSetImpl rs = (ResultSetImpl) st.executeQuery("select kotno from kot where auditdate<'"+dt + "'& kottime<"+"'"+frm.print(tm)+"'");
			System.out.println("inside kotgenerator "+dt+"\n\n"+tm);
			rs.afterLast();
			rs.previous();
			kotno=rs.getString("kotno");
			String [] temp = kotno.split("-");
			int kotnumber=Integer.parseInt(temp[1]);
			kotnumber+=1;
			kotno=temp[0]+"-"+kotnumber;
		}
		//how to parse and increment kotno??
		catch(Exception e){
			e.printStackTrace();
		}
		return kotno;
	}
}
