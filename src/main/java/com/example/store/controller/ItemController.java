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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.model.Item;
import com.example.store.service.ItemService;

@RestController
@CrossOrigin(origins = "https://shopping-website-121.vercel.app") // Replace with the correct URL of your React application
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(itemService.getItems());
    }

    @GetMapping("/sellerItems/{seller}")
    public ResponseEntity<List<Item>> getSellerItems(@PathVariable String seller) {
        return ResponseEntity.ok(itemService.getSellerItems(seller));
    }

    @GetMapping("/itemsByCategory")
    public ResponseEntity<List<Item>> getItemsByCategory(@RequestParam("category") String category) {
        return ResponseEntity.ok(itemService.getItemsByCategory(category));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        try {
            Item addedItem = itemService.addItem(item);
            if (addedItem != null) {
                return ResponseEntity.ok("Item added successfully");
            } else {
                return ResponseEntity.badRequest().body("Failed to add item");
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/edit/{itemId}")
    public ResponseEntity<Void> updateItem(@PathVariable Integer itemId, @RequestBody Item updatedItem) {
        itemService.updateItem(itemId, updatedItem);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.ok(null);
    }
    @GetMapping("/items/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer itemId) {
        Item item = itemService.getItemById(itemId);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
