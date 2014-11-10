package com.Hotelsoft.DatabaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class GetMenu extends ConnectionManager {
	
	
	private Statement st = null;
	private ResultSet rs = null;
	private HashMap menuMap = new HashMap();
	
	public GetMenu(){
		connection = super.getConnection();
		try{
			st = (Statement)connection.createStatement();
			rs = (ResultSet)st.executeQuery("SELECT menuitem.menuItemId, menuitem.menuItemName, menuitem.GroupNo, menuitem.DeptNo, menuitem.posno, menuitemrate.rate, splinst.splname FROM menuitem INNER JOIN menuitemrate ON menuitemrate.menuItemId = menuitem.menuItemId INNER JOIN splinst ON splinst.menuItemId= menuitem.menuItemId");
			System.out.println("in cins");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public HashMap returnMenuItems()
	{
		String itemId, itemName = null, itemGroup, itemDeptNo , posNo, itemRate, splInstName, cmp = "tart";
		HashMap menuMap = new HashMap();
		HashMap subMenuMap = new HashMap();
		HashMap cloneMap = new HashMap();
		ArrayList itemList = new ArrayList();
		ArrayList copyList = new ArrayList();
		try {
			while (rs.next())
			{
				
				itemId = rs.getString("menuItemId");
				
				itemName = rs.getString("menuItemName");
				itemGroup = rs.getString("GroupNo");
			
				itemDeptNo = rs.getString("DeptNo");
				
				posNo = rs.getString("posno");
				
				itemRate = rs.getString("rate");
				if  (cmp.equalsIgnoreCase(itemId))
				{
					splInstName = rs.getString("splname");

					//itemList.add(splInstName);
				
				
				copyList = (ArrayList) itemList.clone();
				
				cloneMap.put("splinst", copyList);
				 menuMap.put(itemId,subMenuMap);
				//itemList.clear();
				
				}
				
				else
				{
					System.out.println("else else");
					itemList.clear();
					subMenuMap.clear();
					subMenuMap.put("itemid", itemId);
					subMenuMap.put("itemname", itemName);
					itemGroup = rs.getString("GroupNo");
					subMenuMap.put("itemgroup", itemGroup);
					itemDeptNo = rs.getString("DeptNo");
					subMenuMap.put("itemDeptNo", itemDeptNo);
					posNo = rs.getString("posno");
					subMenuMap.put("posno", posNo);
					itemRate = rs.getString("rate");
					subMenuMap.put("itemrate", itemRate);
					splInstName = rs.getString("splname");
					itemList.add(splInstName);
					
			         cloneMap = (HashMap) subMenuMap.clone();
					
					copyList = (ArrayList) itemList.clone();
					subMenuMap.put("splinst", copyList);
					menuMap.put(itemId, subMenuMap);
					
				}
				
				cmp = itemId;
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(menuMap);
		return menuMap;
		
	}

}
