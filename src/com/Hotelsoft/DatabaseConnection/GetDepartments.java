package com.Hotelsoft.DatabaseConnection;

/*
 * added finally clause to try catch inside returnDepartments() to close connections after everything is done
 * moved hashmap declarations inside the returnDepartments();
 */
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;

/*
 * unused imports
 * import org.json.JSONArray;
 * import org.json.JSONObject;
 * import com.mysql.jdbc.Connection;
 * import com.mysql.jdbc.ResultSet; //imported when using old version of MySQL
 */
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;

public class GetDepartments extends ConnectionManager {

	private Statement st = null;
	// private ResultSet rs = null;//used whith older versions of MySQL
	private ResultSetImpl rs = null;

	public GetDepartments() {
		System.out.println("Hello");
		connection = super.getConnection();
		try {
			st = (Statement) connection.createStatement();
			// rs = (ResultSet)
			// st.executeQuery("SELECT department.deptid, department.deptname from department");//for
			// use with old versions of MySQL
			rs = (ResultSetImpl) st
					.executeQuery("SELECT department.deptid, department.deptname from department");
			System.out.println("in cins");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList returnDepartments() {
		/*
		 * function to extract department details from db and return to the
		 * calling function
		 */
		ArrayList departmentList = new ArrayList();// actual arraylist that will be used to return list of departments
		HashMap tempDeptHold = new HashMap();// temporary hashmap to store department id and name
		HashMap copyDept = new HashMap();// temporary hashmap to store clone of tempDeptHold
		// ArrayList copyList = new ArrayList();

		/*
		 * the following code could be used instead of using hashmaps to create a JSON object
		 * JSONObject departmentDetail = new JSONObject(); JSONArray
		 * tempDeptArrayHold = new JSONArray(); JSONObject tempDepHold = new
		 * JSONObject();
		 */
		// String cmp =null;
		String deptRec = null;
		String deptNo = null;
		// String groupName = null;
		// String groupNo = null;
		try {
			while (rs.next()) {
				deptRec = rs.getString("deptname");
				deptNo = rs.getString("deptid");
				// groupName = rs.getString("groupname");
				// groupNo = rs.getString("groupno");
				tempDeptHold.clear();
				// subDepartment.clear();
				// subGroup.put(groupName, groupNo);
				// cloneGroup = (HashMap) subGroup.clone();
				// groupList.clear();
				// groupList.add(groupName);
				// groupList.add(groupNo);
				tempDeptHold.put("deptNo", deptNo);
				tempDeptHold.put("departmentName", deptRec);
				copyDept = (HashMap) tempDeptHold.clone();// cloned the
															// temDeptHold as it
															// erases the
															// previous entries
															// if directly added
				// tempDeptHold.clear();
				// departmentList.add(tempDeptHold);
				// tempDeptHold.clear();
				// System.out.println("Else" + deptRec);
				// cmp = null;
				// departMentMap.put(deptRec, cloneGroup);
				departmentList.add(copyDept);
				// cmp = deptRec;
				// temprs = rs.getArray()
			}
			System.out.println(departmentList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return departmentList;
	}
}