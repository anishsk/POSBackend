package com.Hotelsoft.JavaClasses;

import java.util.ArrayList;

@SuppressWarnings({"unused","rawtypes"})
public class Orders {

	private int quantity;
	private String spclInst;
	private int tableNo;
	private String orderType;
	private ArrayList orderList;  
	
	public Orders() {
		quantity =0;
		spclInst=null;
		tableNo=-1;
		orderType=null;
		orderList = new ArrayList();
	}
	
	public void setOrderDetail(int qty, String spclist, int tn, String ot, ArrayList ol){
		quantity=qty;
		spclInst=spclist;
		tableNo=tn;
		orderType=ot;
		orderList=ol;
	}
	
	public void insertOrders(){
		
	}
	
}
