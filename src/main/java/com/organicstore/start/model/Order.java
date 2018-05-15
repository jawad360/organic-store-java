package com.organicstore.start.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection = "order")
public class Order {
	@Id
	private String id;
	private String userId;
	private Date date;
	private String status;
	private float price;
	private List<OrderDetails> orderDetails;

	public Order() {
		super();
	}

	public Order(String id, String userId, String inventoryId, Date date, String status, float price,
			List<OrderDetails> orderDetails) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.status = status;
		this.price = price;
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + "userId= " + userId + ", date=" + date + ", status=" + status + ", price=" + price
				+ ", orderDetails=" + orderDetails + "]";
	}

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
