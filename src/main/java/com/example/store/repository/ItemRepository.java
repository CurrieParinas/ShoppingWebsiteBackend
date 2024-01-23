package com.example.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.store.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	public List<Item> findBySellerName(String seller);

	public List<Item> findByCategory(String category);

	public Optional<Item> findFirstByOrderByItemIdDesc();
	@Query("SELECT MAX(i.itemId) FROM Item i")
	Integer findMaxItemId();
}
