package com.sos.example.salesorderservice.model;

public class Item {

	private Long itemId;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int quantity;
	
	public Item(){
		
	}

	public Item(Long itemId, String name, String description, double price, int quantity) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
