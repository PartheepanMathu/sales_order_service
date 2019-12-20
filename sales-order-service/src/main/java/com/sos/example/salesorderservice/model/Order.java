package com.sos.example.salesorderservice.model;

import java.util.Date;
import java.util.List;

public class Order {

	private String orderDesc;
	
	//private Date orderDate;
	
	private Long custId;
	
	private List<Item> items;
	
	public Order(){
		
	}

	public Order(String orderDesc, Long custId, List<Item> items) {
		super();
		this.orderDesc = orderDesc;
		this.custId = custId;
		this.items = items;
	}

	/*public Order(String orderDesc, Date orderDate, Long custId) {
		super();
		this.orderDesc = orderDesc;
		//this.orderDate = orderDate;
		this.custId = custId;
	}*/

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	/*public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}*/

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
