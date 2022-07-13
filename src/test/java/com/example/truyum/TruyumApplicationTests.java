package com.example.truyum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.truyum.service.CartItemService;
import com.example.truyum.service.MenuItemsService;

@SpringBootTest
class TruyumApplicationTests {
	
	@Autowired
	MenuItemsService menuService;
	@Autowired
	CartItemService cartService;

	@Test
	void contextLoads() {
	}
	
	@Test
	void addToCart() {
		cartService.AddNewItem(menuService.getProduct(1));
	}
	
}
