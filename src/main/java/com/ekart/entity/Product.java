package com.ekart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EK_PRODUCT")
public class Product {
	public Product() {
	}
	public Product(Integer productId, String category, String type, String name, String model,Double price,
			Integer quantity) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.model = model;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	public Product(Integer productId, String name, String category, String model, String type, Double price,
			Integer quantity, String sellerEmail) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.model = model;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.sellerEmail = sellerEmail;
	}
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="PRICE")
	private Double price;

	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="SELLER_EMAIL_ID")
	private String sellerEmail;
	
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public Integer getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
}
