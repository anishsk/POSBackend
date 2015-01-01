package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;

@SuppressWarnings({"unused"})
public class OrderItem {

	private int quantity;
	private String spclInst;
	private int tableNo;
	private String orderType;
	
	public OrderItem() {
		quantity =0;
		spclInst=null;
		tableNo=-1;
		orderType=null;
		orderItem = null;
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

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	private String orderItem;  
	
	
	/*public void setOrderDetail(int qty, String spclist, int tn, String ot, String ol){
		quantity=qty;
		spclInst=spclist;
		tableNo=tn;
		orderType=ot;
		orderItem=ol;
	}*/
}
