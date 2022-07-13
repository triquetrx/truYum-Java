package com.example.truyum.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.truyum.entity.MenuItems;
import com.example.truyum.service.MenuItemsService;
import com.example.truyum.util.ApplicationUtil;

@Controller
public class AdminController {
	
	@Autowired
	ApplicationUtil listUtil;
	@Autowired
	MenuItemsService service;
	
	@RequestMapping("menu-item-list-admin")
	public String adminHomePage(ModelMap model) {
		if(service.isData()) {			
			return "menu-item-list-admin";
		}
		model.addAttribute("menuList",service.viewAll());
		return "menu-item-list-admin";
		
	}
	
	@RequestMapping("add-admin-items")
	public String addProducts(ModelMap model) {
		model.put("newItem", new MenuItems());
		model.put("categoryList", listUtil.getCategoryList());
		model.put("activeList", listUtil.getActiveList());
		return "add-items";
	}

	@RequestMapping("edit-admin")
	public String editProduct(ModelMap model,@RequestParam long id) {
		model.put("categoryList", listUtil.getCategoryList());
		model.put("activeList", listUtil.getActiveList());
		model.put("editItem", service.getProduct(id));
		return "edit-admin";
	}
	
	@RequestMapping(value="edit-admin", method=RequestMethod.POST)
	public String editedProduct(ModelMap model,@Valid @ModelAttribute("editItem")MenuItems menu,BindingResult result) {
		if(result.hasErrors()) {
			return "edit-admin";
		}
		service.editItem(menu.getItemId(),menu.getName(), menu.getPrice(), menu.getIsActive(), menu.getDateOfLaunch(), menu.getCategory(), menu.getIsFreeDelivery());
		return "redirect:menu-item-list-admin";
	}
	
	@RequestMapping(value="add-admin-items",method=RequestMethod.POST)
	public String addNewProducts(ModelMap model,@Valid @ModelAttribute("newItems")MenuItems menu,BindingResult results) {
		model.put("newItem", new MenuItems());
		if(results.hasErrors()) {
			return "add-items";
		}
		// String name,double price,String isActive,Date DateOfLaunch,String Category,boolean isFreeDelivery
		service.addNewItem(menu.getName(), menu.getPrice(), menu.getIsActive(), menu.getDateOfLaunch(), menu.getCategory(), menu.getIsFreeDelivery());
		return "redirect:menu-item-list-admin";
	}
}
