package com.organicstore.start.model;

public class OrderDetails {
	private String inventoryId;
	private int quantity;

	public OrderDetails(String inventoryId, int quantity) {
		super();
		this.inventoryId = inventoryId;
		this.quantity = quantity;
	}
	
	public OrderDetails() {
	}

	@Override
	public String toString() {
		return "OrderDetails [inventoryId=" + inventoryId + ", quantity=" + quantity + "]";
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
