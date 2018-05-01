package com.organicstore.start.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
	private String id;
	private String inventoryId;
	private Date date;
	private String status;
	private float price;
	private OrderDetails orderDetails;

	public Order() {
		super();
	}

	public Order(String id, String inventoryId, Date date, String status, float price, OrderDetails orderDetails) {
		super();
		this.id = id;
		this.inventoryId = inventoryId;
		this.date = date;
		this.status = status;
		this.price = price;
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", inventoryId=" + inventoryId + ", date=" + date + ", status=" + status + ", price="
				+ price + ", orderDetails=" + orderDetails + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

}
