package com.organicstore.start.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public class Category {

	private String id;
	private String name;
	private String description;
	private String photoM;
	private String photoL;
	@DBRef
	private List<Product> product;

	public Category(String id, String name, String description, String photoM, String photoL, List<Product> product,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photoM = photoM;
		this.photoL = photoL;
		this.product = product;
	}

	public Category() {

	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", photoM=" + photoM
				+ ", photoL=" + photoL + ", product=" + product + "]";
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
