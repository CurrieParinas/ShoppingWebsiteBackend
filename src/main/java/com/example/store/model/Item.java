package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@Column(name = "item_id")
	@JsonProperty("item_id")
	Integer itemId;
	
	@Column(name = "picture")
	@JsonProperty("picture")
	String picture;
	
	@Column(name = "item_name")
	@JsonProperty("item_name")
	String itemName;
	
	@Column(name = "category")
	@JsonProperty("category")
	String category;
	
	@Column(name = "seller_name")
	@JsonProperty("seller_name")
	String sellerName;

	@Column(name = "description")
	@JsonProperty("description")
	String description;
	
	@Column(name = "price")
	@JsonProperty("price")
	Integer price;
	
	@Column(name = "stocks")
	@JsonProperty("stocks")
	Integer stocks;

	public Item() {
		
	}

	public Item(Integer itemId, String picture, String itemName, String category, String sellerName, String description, Integer price, Integer stocks) {
		this.itemId = itemId;
		this.picture = picture;
		this.itemName = itemName;
		this.category = category;
		this.sellerName = sellerName;
		this.description = description;
		this.price = price;
		this.stocks = stocks;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStocks() {
		return stocks;
	}

	public void setStocks(Integer stocks) {
		this.stocks = stocks;
	}
}