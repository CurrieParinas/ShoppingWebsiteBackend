package com.example.store.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.store.model.Sold;
import com.example.store.repository.SoldRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SoldService {
	@Autowired
	SoldRepository soldRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Sold> getSold(String seller) {
		return soldRepo.findBySellerName(seller);
	}
	
	public List<Sold> getPurchaseHistory(String buyer) {
		return soldRepo.findByBuyerName(buyer);
	}
	
	public void checkout(String username, String shippingAddress, String paymentMode) {
		jdbcTemplate.execute("SELECT CHECKOUT(?,?,?)", (PreparedStatementCallback<Void>) ps -> {
	        ps.setString(1, username);
	        ps.setString(2, shippingAddress);
	        ps.setString(3, paymentMode);
	        ps.execute();
	        return null;
	    });
	}
	
	public void setShipping(Integer transNo) {
		Sold existingTrans = soldRepo.findById(transNo)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with No: " + transNo));
		
		existingTrans.setOrderStatus("Shipping order");
		soldRepo.save(existingTrans);
	}
	
	public void setDelivered(Integer transNo) {
		Sold existingTrans = soldRepo.findById(transNo)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with No: " + transNo));
		
		existingTrans.setOrderStatus("Order Delivered");
		soldRepo.save(existingTrans);
	}
	
	public ResponseEntity<String> setCompleted(@PathVariable Integer transNo) {
		  LocalDate currentDate = LocalDate.now();
		  Sold existingTrans = soldRepo.findById(transNo)
		          .orElseThrow(() -> new EntityNotFoundException("Transaction not found with No: " + transNo));

		  String status = existingTrans.getOrderStatus();

		  if (status.equals("Order Delivered")) {
		    existingTrans.setOrderStatus("Transaction Completed");
		    existingTrans.setDateDelivered(currentDate);
		    soldRepo.save(existingTrans);
		    return ResponseEntity.ok("Transaction Completed");
		  } else {
		    return ResponseEntity.badRequest().body("Transaction cannot be completed. Product has not yet been delivered.");
		  }
		}
}
