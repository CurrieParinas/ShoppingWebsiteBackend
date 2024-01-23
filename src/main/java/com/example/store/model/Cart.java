package com.example.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "item_no")
	@JsonProperty("item_no")
	Integer itemNo;
	
	@Column(name = "buyer_name")
	@JsonProperty("buyer_name")
	String buyerName;
	
	@Column(name = "item_id")
	@JsonProperty("item_id")
	Integer itemId;
	
	@Column(name = "item_name")
	@JsonProperty("item_name")
	String itemName;
	
	@Column(name = "category")
	@JsonProperty("category")
	String category;
	
	@Column(name = "seller_name")
	@JsonProperty("seller_name")
	String sellerName;
	
	@Column(name = "price")
	@JsonProperty("price")
	Integer price;
	
	@Column(name = "amount")
	@JsonProperty("amount")
	Integer amount;
	
	@Column(name = "total_cost")
	@JsonProperty("total_cost")
	Integer totalCost;
	
	public Cart() {
		
	}

	public Cart(Integer itemNo, String buyerName, Integer itemId, String itemName, String category, String sellerName, Integer price, Integer amount, Integer totalCost) {
		this.itemNo = itemNo;
		this.buyerName = buyerName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.amount = amount;
		this.totalCost = totalCost;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
}
