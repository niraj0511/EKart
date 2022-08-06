package com.ekart.dto;

import java.util.List;

public class ProductDTO {

	public ProductDTO() {
	
	}
	public ProductDTO(Integer productId, String category, String type, String name, String model,Double price,
			Integer quantity) {
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.model = model;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	private Integer productId;
	private String name;
	private String category;
	private String model;
	private Double price;
	private Integer quantity;
	private String type;
	private String sellerEmail;
	private String errorMessage;
	private String successMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmailId(String sellerEmailId) {
		this.sellerEmail = sellerEmailId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
}
