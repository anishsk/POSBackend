package com.Hotelsoft.JavaClasses;

@SuppressWarnings("unused")
public abstract class Orders {

	private int quantity;
	private String spclInst;
	private String tableNo=null;
	private String orderType=null;
	
	public Orders() {
		quantity =0;
		spclInst=null;
		tableNo=null;
		orderType=null;
	}
	
	public abstract void setOrderDetail();
	
	public abstract void insertOrders();
	
}
