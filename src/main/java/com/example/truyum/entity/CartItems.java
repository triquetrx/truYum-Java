package com.example.truyum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@SuppressWarnings("unused")
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartProductId;
	private long userId;
	@OneToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItems menuItem;

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItems(MenuItems menuItem) {
		super();
		this.menuItem = menuItem;
		this.userId = 1;
	}

	public long getCart_id() {
		return cartProductId;
	}

	public void setCart_id(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public MenuItems getMenu() {
		return menuItem;
	}

	public void setMenu(MenuItems menuItem) {
		this.menuItem = menuItem;
	}
}
