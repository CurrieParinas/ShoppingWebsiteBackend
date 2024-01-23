package com.example.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.model.Cart;
import com.example.store.service.CartService;

@RestController
@CrossOrigin(origins = "https://shopping-website-121.vercel.app") // Replace with the correct URL of your React application
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart/{buyer}")
    public ResponseEntity<List<Cart>> getCart(@PathVariable String buyer) {
        return ResponseEntity.ok(cartService.getCart(buyer));
    }
    
    @GetMapping("/cartNumItems/{buyer}")
    public ResponseEntity<Integer> getCartNumItems(@PathVariable String buyer) {
        return ResponseEntity.ok(cartService.getCart(buyer).size());
    }

    @PostMapping("/addToCart/{buyer}/{itemId}/{amount}")
    public ResponseEntity<Void> addToCart(
            @PathVariable String buyer,
            @PathVariable Integer itemId,
            @PathVariable Integer amount
    ) {
        cartService.addToCart(buyer, itemId, amount);
        return ResponseEntity.ok(null);
    }
    
    @PutMapping("/addAmount/{itemNo}")
    public ResponseEntity<Void> addAmount(@PathVariable Integer itemNo) {
    	cartService.addAmount(itemNo);
        return ResponseEntity.ok(null);
    }
    
    @PutMapping("/reduceAmount/{itemNo}")
    public ResponseEntity<Void> reduceAmount(@PathVariable Integer itemNo) {
    	cartService.reduceAmount(itemNo);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/removeFromCart/{itemNo}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Integer itemNo) {
        cartService.removeFromCart(itemNo);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/removeAllFromCart/{buyer}")
    public ResponseEntity<Void> removeAllFromCart(@PathVariable String buyer) {
        cartService.removeAllFromCart(buyer);
        return ResponseEntity.ok().build();
    }

}
