package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;

@SuppressWarnings({"unused"})
public class OrderItem {

	//keeping table no a part of OrderItem because it will become easy to insert into the DB
	private int quantity;
	private String spclInst;
	private int tableNo;
	private String itemType;
	private String orderItemName;
	
	public OrderItem() {
		quantity =0;
		spclInst=null;
		tableNo=-1;
		itemType=null;
		orderItemName = null;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSpclInst() {
		return spclInst;
	}

	public void setSpclInst(String spclInst) {
		this.spclInst = spclInst;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String orderType) {
		this.itemType = orderType;
	}

	public String getOrderItemName() {
		return orderItemName;
	}

	public void setOrderItemName(String orderItem) {
		this.orderItemName = orderItem;
	}
	
	
	/*public void setOrderDetail(int qty, String spclist, int tn, String ot, String ol){
		quantity=qty;
		spclInst=spclist;
		tableNo=tn;
		itemType=ot;
		orderItemName=ol;
	}*/
}
