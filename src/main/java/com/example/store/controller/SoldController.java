package com.example.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.model.Sold;
import com.example.store.service.SoldService;

@RestController
@CrossOrigin(origins = "https://shopping-website-121.vercel.app") // Replace with the correct URL of your React application
public class SoldController {
	@Autowired
	SoldService soldService;
	
	@GetMapping("/sold/{seller}")
	public ResponseEntity<List<Sold>> getSold(@PathVariable String seller) {
		return ResponseEntity.ok(soldService.getSold(seller));
	}
	
	@GetMapping("/purchaseHistory/{buyer}")
	public ResponseEntity<List<Sold>> getPurchaseHistory(@PathVariable String buyer) {
		return ResponseEntity.ok(soldService.getPurchaseHistory(buyer));
	}
	
	@PostMapping("/checkout/{username}")
	public ResponseEntity<Void> checkout(@PathVariable String username, @RequestBody Map<String, String> request) {
		String paymentMode = request.get("paymentMode");
		String shippingAddress = request.get("shippingAddress");
		soldService.checkout(username, shippingAddress, paymentMode);
		
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/setShipping/{transNo}")
	public ResponseEntity<String> setShipping(@PathVariable Integer transNo) {
		soldService.setShipping(transNo);
		return ResponseEntity.ok("Shipping order");
	}
	
	@PutMapping("/setDelivered/{transNo}")
	public ResponseEntity<String> setDelivered(@PathVariable Integer transNo) {
		soldService.setDelivered(transNo);
		return ResponseEntity.ok("Order Delivered");
	}
	@CrossOrigin(origins = "https://shopping-website-121.vercel.app")
	@PutMapping("/setCompleted/{transNo}")
	public ResponseEntity<ResponseEntity<String>> setCompleted(@PathVariable Integer transNo) {
		return ResponseEntity.ok(soldService.setCompleted(transNo));
	}
}
