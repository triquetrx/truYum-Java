package com.example.truyum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public @Data @NoArgsConstructor class Cart {

	@Id
	@Column(name="cart_product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	private long userId;
	@OneToOne
	@JoinColumn(name = "menu_item_id")
	private MenuItems menu;

	public Cart(MenuItems menu) {
		super();
		this.menu = menu;
		this.userId = 1L;
	}
}
