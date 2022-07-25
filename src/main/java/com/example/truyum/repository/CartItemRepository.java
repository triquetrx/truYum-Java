package com.example.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.truyum.entity.Cart;
import com.example.truyum.entity.MenuItems;

public interface CartItemRepository extends JpaRepository<Cart, Long> {
	
	void deleteById(Long id);
	List<Cart> findAll();
	void save(MenuItems menuItem);
	
}
