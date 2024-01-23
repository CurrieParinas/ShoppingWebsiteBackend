package com.example.store.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sold")
public class Sold {
	@Id
	@Column(name = "transaction_no")
	@JsonProperty("transaction_no")
	Integer transactionNo;
	
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
	
	@Column(name = "transaction_cost")
	@JsonProperty("transaction_cost")
	Integer transactionCost;
	
	@Column(name = "payment_method")
	@JsonProperty("payment_method")
	String paymentMethod;
	
	@Column(name = "address")
	@JsonProperty("address")
	String address;
	
	@Column(name = "checkout_date")
	@JsonProperty("checkout_date")
	String checkoutDate;
	
	@Column(name = "expected_delivery_date")
	@JsonProperty("expected_delivery_date")
	String expectedDate;
	
	@Column(name = "date_delivered")
	@JsonProperty("date_delivered")
	LocalDate dateDelivered;
	
	@Column(name = "order_status")
	@JsonProperty("order_status")
	String orderStatus;
	
	public Sold() {
		
	}

	public Sold(Integer transactionNo, String buyerName, Integer itemId, String itemName, String category,
			String sellerName, Integer price, Integer amount, Integer transactionCost, String paymentMethod,
			String address, String checkoutDate, String expectedDate, LocalDate dateDelivered, String orderStatus) {
		this.transactionNo = transactionNo;
		this.buyerName = buyerName;
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.sellerName = sellerName;
		this.price = price;
		this.amount = amount;
		this.transactionCost = transactionCost;
		this.paymentMethod = paymentMethod;
		this.address = address;
		this.checkoutDate = checkoutDate;
		this.expectedDate = expectedDate;
		this.dateDelivered = dateDelivered;
		this.orderStatus = orderStatus;
	}

	public Integer getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
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

	public Integer getTransactionCost() {
		return transactionCost;
	}

	public void setTransactionCost(Integer transactionCost) {
		this.transactionCost = transactionCost;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public String getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

	public LocalDate getDateDelivered() {
		return dateDelivered;
	}

	public void setDateDelivered(LocalDate dateDelivered) {
		this.dateDelivered = dateDelivered;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}
