package com.organicstore.start.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
public class Inventory {

	@Id
	private String id;
	private String productId;
	private String vendorId;
	private String name;
	private int quantity;
	private float pricePerUnit;
	private String unit;
	private float quantityPerUnit;

	public Inventory() {
		super();
	}

	public Inventory(String id, String productId, String vendorId, String name, int quantity, float pricePerUnit,
			String unit, float quantityPerUnit) {
		super();
		this.id = id;
		this.productId = productId;
		this.vendorId = vendorId;
		this.name = name;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.unit = unit;
		this.quantityPerUnit = quantityPerUnit;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", productId=" + productId + ", vendorId=" + vendorId + ", name=" + name
				+ ", quantity=" + quantity + ", pricePerUnit=" + pricePerUnit + ", unit=" + unit + ", quantityPerUnit="
				+ quantityPerUnit + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(float quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

}
