package com.Hotelsoft.DatabaseConnection;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class GetDepartments extends ConnectionManager {
	
	private Statement st = null;
	private ResultSet rs = null, temprs=null;
	
	HashMap tempDeptHold = new HashMap();
	HashMap copyDept = new HashMap();
	
	
	
	public  GetDepartments ()
	{
		System.out.println("Hello");
		connection = super.getConnection();
	
		
		try{
			st = (Statement)connection.createStatement();
			rs = (ResultSet)st.executeQuery("SELECT department.deptid, department.deptname from department");
			System.out.println("in cins");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList returnDepartments(){
		ArrayList departmentList = new ArrayList();
		//ArrayList copyList = new ArrayList();

		/*JSONObject departmentDetail = new JSONObject();
		JSONArray tempDeptArrayHold = new JSONArray();
		JSONObject tempDepHold = new JSONObject();*/
		String cmp =null;
		String deptRec = null;
		String deptNo = null;
		//String groupName = null;
		//String groupNo = null;
		try {
			while(rs.next()){
				deptRec = rs.getString("deptname");
				deptNo = rs.getString("deptid");
				//groupName = rs.getString("groupname");
				//groupNo = rs.getString("groupno");
				
				
				

				
				
				
					tempDeptHold.clear();
                  //subDepartment.clear();
                  //  subGroup.put(groupName, groupNo);
                  //  cloneGroup = (HashMap) subGroup.clone();
				//	groupList.clear();
				//	groupList.add(groupName);
					//groupList.add(groupNo);
					tempDeptHold.put("deptNo",deptNo);
					tempDeptHold.put("departmentName",deptRec);
					copyDept=(HashMap) tempDeptHold.clone();
					//tempDeptHold.clear();
					//departmentList.add(tempDeptHold);
					//tempDeptHold.clear();
					//System.out.println("Else" + deptRec);
					
					//cmp = null;
				
				//departMentMap.put(deptRec, cloneGroup);
				departmentList.add(copyDept);
				
				cmp = deptRec;
			//	temprs = rs.getArray()
						
						
						
			}
		
			System.out.println(departmentList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return departmentList;
	}
}