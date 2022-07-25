package com.example.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.truyum.entity.Cart;
import com.example.truyum.entity.MenuItems;
import com.example.truyum.repository.CartItemRepository;

@Service
public class CartItemService {
	
	@Autowired
	CartItemRepository repository;
	
	public void AddNewItem(MenuItems menuItem) {
		repository.save(new Cart(menuItem));
	}
	
	public List<Cart> GetAllCartItems() {
		return repository.findAll();
	}
	
	
	public void DeleteCartItem(long id) {
		repository.deleteById(id);
		
	}
	
}
