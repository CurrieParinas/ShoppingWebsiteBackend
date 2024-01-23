package com.example.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.store.model.Sold;

@Repository
public interface SoldRepository extends JpaRepository<Sold, Integer>{
	public List<Sold> findBySellerName(String seller);
	public List<Sold> findByBuyerName(String buyer);
}
