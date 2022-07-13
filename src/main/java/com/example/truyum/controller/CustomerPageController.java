package com.example.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.truyum.service.CartItemService;
import com.example.truyum.service.MenuItemsService;

@Controller
public class CustomerPageController {

	@Autowired
	MenuItemsService menuService;
	@Autowired
	CartItemService cartService;

	@RequestMapping(value = { "", "/", "menu-item-list-customer" }, method = RequestMethod.GET)
	public String HomePageCustomer(ModelMap model) {
		model.put("menuCustomer", menuService.viewAll());
		return "menu-item-list-customer";
	}

	@RequestMapping(value = { "add-to-cart" }, method = RequestMethod.GET)
	public String AddToCartRequest(ModelMap model, @RequestParam long id) {
		cartService.AddNewItem(menuService.getProduct(id));
		return "redirect:menu-item-list-customer";
	}

	@RequestMapping(value = { "cart" }, method = RequestMethod.GET)
	public String CartPageCustomer(ModelMap model) {
		model.put("cartProduct", cartService.GetAllCartItems());
		return "cart";
	}
	
	@GetMapping("delete_cart_item")
	public String DeleteCartProduct(@RequestParam("cartid") long cartId) {
		cartService.DeleteCartItem(cartId);
		return "redirect:cart";
	}
}
