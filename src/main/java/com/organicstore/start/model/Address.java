package com.organicstore.start.model;

public class Address {
	private String id;
	private String address;
	private String pincode;

	public Address(String id, String address, String pincode) {
		super();
		this.id = id;
		this.address = address;
		this.pincode = pincode;
	}

	public Address() {
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", pincode=" + pincode + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
