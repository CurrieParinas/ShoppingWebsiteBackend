package com.example.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import com.example.store.model.Cart;
import com.example.store.repository.CartRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cart> getCart(String buyer) {
        return cartRepo.findByBuyerName(buyer);
    }

    public void addToCart(String buyer, Integer itemId, Integer amount) {
        jdbcTemplate.execute("SELECT ADDTOCART(?,?,?)", (PreparedStatementCallback<Void>) ps -> {
            ps.setString(1, buyer);
            ps.setInt(2, itemId);
            ps.setInt(3, amount);
            ps.execute();
            return null;
        });
    }
    
    public Cart addAmount(Integer itemNo) {
		Cart cartItem = cartRepo.findById(itemNo)
				.orElseThrow(() -> new EntityNotFoundException("Item not found with No: " + itemNo));
		Integer newAmount = cartItem.getAmount() + 1;
		Integer newTotalCost = newAmount * cartItem.getPrice();
		
		cartItem.setAmount(newAmount);
		cartItem.setTotalCost(newTotalCost);
		
		return cartRepo.save(cartItem);
	}
    
    public Cart reduceAmount(Integer itemNo) {
        Cart cartItem = cartRepo.findById(itemNo)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with No: " + itemNo));
        Integer newAmount = cartItem.getAmount() - 1;
        Integer newTotalCost = newAmount * cartItem.getPrice();

        if (newAmount <= 0) {
            cartRepo.deleteById(itemNo); // Delete the item from the repository
            return null; // Return null to indicate the item was deleted
        }

        cartItem.setAmount(newAmount);
        cartItem.setTotalCost(newTotalCost);

        return cartRepo.save(cartItem);
    }


    public void removeFromCart(Integer itemNo) {
        cartRepo.deleteById(itemNo);
    }
    @Transactional
    public void removeAllFromCart(String buyer) {
        cartRepo.deleteByBuyerName(buyer);
    }
}