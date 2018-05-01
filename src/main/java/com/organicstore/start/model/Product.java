package com.organicstore.start.model;

public class Product {
	private String id;
	private String name;
	private String description;
	private String photoM;
	private String photoL;
	
	public Product(String id, String name, String description, String photoM, String photoL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photoM = photoM;
		this.photoL = photoL;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", photoM=" + photoM
				+ ", photoL=" + photoL + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhotoM() {
		return photoM;
	}
	public void setPhotoM(String photoM) {
		this.photoM = photoM;
	}
	public String getPhotoL() {
		return photoL;
	}
	public void setPhotoL(String photoL) {
		this.photoL = photoL;
	}
	
}
