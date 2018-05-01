package com.organicstore.start.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendor")
public class Vendor {

	private String id;
	private String fname;
	private String lname;
	private String phone;
	private String phoneHome;
	private String email;
	private String proofUrl;
	private String rating;
	private String password;
	private Address shopAddress;
	private Address vendorAddress;
	private List<Inventory> inventory;

	public Vendor() {
		super();
	}

	public Vendor(String id, String fname, String lname, String phone, String phoneHome, String email, String proofUrl,
			String rating, String password, Address shopAddress, Address vendorAddress, List<Inventory> inventory) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.phoneHome = phoneHome;
		this.email = email;
		this.proofUrl = proofUrl;
		this.rating = rating;
		this.password = password;
		this.shopAddress = shopAddress;
		this.vendorAddress = vendorAddress;
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", phone=" + phone + ", phoneHome="
				+ phoneHome + ", email=" + email + ", proofUrl=" + proofUrl + ", rating=" + rating + ", password="
				+ password + ", shopAddress=" + shopAddress + ", vendorAddress=" + vendorAddress + ", inventory="
				+ inventory + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProofUrl() {
		return proofUrl;
	}

	public void setProofUrl(String proofUrl) {
		this.proofUrl = proofUrl;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Address getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(Address vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}

}
