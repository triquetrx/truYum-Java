package com.example.truyum.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.truyum.entity.MenuItems;
import com.example.truyum.repository.MenuItemsRepository;
import com.example.truyum.util.ApplicationUtil;

@Service
public class MenuItemsService {

	@Autowired
	MenuItemsRepository repos;
	@Autowired
	ApplicationUtil util;

	@Transactional
	public void addNewItem(String name, double price, boolean isActive, Date DateOfLaunch, String Category,
			boolean isFreeDelivery) {
		repos.save(new MenuItems( name, isActive, DateOfLaunch, price, Category, isFreeDelivery));
	}

	@Transactional
	public void editItem(long id, String name, double price, boolean isActive, Date DateOfLaunch, String Category,
			boolean isFreeDelivery) {
		MenuItems item = getProduct(id);
		item.setCategory(Category);
		item.setDateOfLaunch(DateOfLaunch);
		item.setFreeDelivery(isFreeDelivery);
		item.setActive(isActive);
		item.setName(name);
		item.setPrice(price);
		repos.save(item);
	}

	@Transactional
	public void deleteItem(long id) {
		repos.deleteById(id);
	}

	@Transactional
	public List<MenuItems> viewAll() {
		return repos.findAll();
	}

	@Transactional
	public MenuItems getProduct(long id) {
		return repos.findById(id).get();
	}

	@Transactional
	public boolean isData() {
		return repos.count() == 0;
	}

}
