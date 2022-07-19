package com.example.truyum.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_items")
public @NoArgsConstructor @Data class MenuItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long itemId;
	@Size(min = 3, message = "Minimum size of the name shoulb be 3")
	@Column(name = "item_name")
	private String name;
	@Column(name = "is_active")
	private boolean active;
	@Column(name="date_of_Launch")
	private Date dateOfLaunch;
	@Column(name="price")
	private double price;
	@Column(name="category")
	private String category;
	@Column(name = "free_delivery")
	private boolean freeDelivery;

	public MenuItems(String name, boolean active, Date dateOfLaunch, double price, String category,
			boolean freeDelivery) {
		super();
		this.name = name;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.price=price;
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

}
