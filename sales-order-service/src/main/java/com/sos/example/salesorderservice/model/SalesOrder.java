package com.sos.example.salesorderservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="cust_id")
	private Long custId;
	
	@Column(name="order_desc")
	private String orderDesc;
	
	@Column(name="total_price")
	private double totalPrice;
	
	public SalesOrder() {
	}

	public SalesOrder(Long orderId, Date orderDate, Long custId, String orderDesc, double totalPrice) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
