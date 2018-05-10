package com.organicstore.start.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {
    @Id
	private String id;
	private String name;
	private String description;
	private String photoM;
	private String photoL;
	private String categoryId;

	public Product(String id, String name, String description, String photoM, String photoL, String categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photoM = photoM;
		this.photoL = photoL;
		this.setCategoryId(categoryId);
	}

	public Product() {

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

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

}
