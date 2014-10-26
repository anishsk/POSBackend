package com.Hotelsoft.DatabaseConnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class GetMenu extends ConnectionManager {
	
	private Statement st = null;
	private ResultSet rs = null, temprs=null;
	private HashMap departMentMap = new HashMap();
	
	
	
	
	
	public  GetMenu ()
	{
		System.out.println("Hello");
		connection = super.getConnection();
		try{
			st = (Statement)connection.createStatement();
			rs = (ResultSet)st.executeQuery("SELECT department.deptid, department.deptname, groups.groupname FROM department INNER JOIN groups ON groups.deptno = department.deptid");
			System.out.println("in cins");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public HashMap returnMenu(){
		ArrayList groupList = new ArrayList();
		ArrayList copyList = new ArrayList();
		String cmp =null;
		String deptRec = null;
		String groupName = null;
		try {
			while(rs.next()){
				
			
				try {
					deptRec = rs.getString("deptname");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				groupName = rs.getString("groupname");
				
				
				if (cmp == null || cmp.equalsIgnoreCase(deptRec))
				{
				//	groupList.clear();
					groupList.add(groupName);
					System.out.println(deptRec);
					copyList = (ArrayList) groupList.clone();
				
				//	cmp = deptRec;
					
					
				}
				
				else
				{

					groupList.clear();
					groupList.add(groupName);
					System.out.println("Else" + deptRec);
					
					//cmp = null;
				}
				
				departMentMap.put(deptRec, copyList);
				
				 cmp = deptRec;
			//	temprs = rs.getArray()
						
						
						
			}
			System.out.println(departMentMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departMentMap;
	}
}
