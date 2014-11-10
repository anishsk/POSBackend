package com.Hotelsoft.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class GetGroups extends ConnectionManager {
	private Statement st = null;
	private ResultSet rs = null, temprs = null;

	public GetGroups() {
		System.out.println("In Get Groups Constructor. getting Connection");
		connection = super.getConnection();

		try {
			st = (Statement) connection.createStatement();
			rs = (ResultSet) st
					.executeQuery("SELECT groups.deptno, groups.groupname,groups.groupno from groups");
			System.out.println("in cins");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList returnGroupList(){
		ArrayList groupList = new ArrayList();
		//HashMap tempGroupHold = new HashMap();
	//	HashMap copyGroup = new HashMap();
		String cmp =null;
		String groupName = null;
		String groupNo = null;
		String groupDeptNo = null;
		
		try {
			while(rs.next()){
				groupDeptNo = rs.getString("deptno");
				groupNo = rs.getString("groupno");
				groupName = rs.getString("groupname");
				HashMap copyGroup = new HashMap();
			
				HashMap tempGroupHold = new HashMap();
			
						//tempGroupHold.clear();
						tempGroupHold.put("deptNo", groupDeptNo);
						tempGroupHold.put("groupName", groupName);
						tempGroupHold.put("groupNo", groupNo);
						copyGroup=(HashMap) tempGroupHold.clone();
					
					groupList.add(tempGroupHold);
					cmp = groupName;
				}
				System.out.println(groupList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return groupList;
	}
}
