package com.example.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.store.model.Item;
import com.example.store.repository.ItemRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepo;

    public List<Item> getItems() {
        return itemRepo.findAll();
    }

    public List<Item> getSellerItems(String seller) {
        return itemRepo.findBySellerName(seller);
    }
    public Item getItemById(Integer itemId) {
        return itemRepo.findById(itemId)
            .orElse(null);
    }

    public List<Item> getItemsByCategory(String category) {
        return itemRepo.findByCategory(category);
    }

    public Item addItem(Item item) {
        try {
            // Get the highest item_id from the existing items
            Optional<Item> highestItemId = itemRepo.findFirstByOrderByItemIdDesc();
            int newItemId = highestItemId.map(Item::getItemId).orElse(0) + 1;
            item.setItemId(newItemId);
            
            return itemRepo.save(item);
        } catch (DataIntegrityViolationException ex) {
            // Handle any other data integrity violation errors
            throw new IllegalArgumentException("Failed to add item. Please check your input.");
        }
    }

    public void deleteItem(Integer itemId) {
        itemRepo.deleteById(itemId);
    }

    public Item updateItem(Integer itemId, Item updatedItem) {
        Item existingItem = itemRepo.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with ID: " + itemId));

        existingItem.setPicture(updatedItem.getPicture());
        existingItem.setItemName(updatedItem.getItemName());
        existingItem.setCategory(updatedItem.getCategory());
        existingItem.setSellerName(updatedItem.getSellerName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setStocks(updatedItem.getStocks());

        return itemRepo.save(existingItem);
    }
}
