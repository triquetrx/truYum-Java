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

@Entity
@Table(name = "menu_items")
public class MenuItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long itemId;
	@Size(min = 3, message = "Minimum size of the name shoulb be 3")
	@Column(name = "item_name")
	private String name;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name="date_of_Launch")
	private Date dateOfLaunch;
	@Column(name="price")
	private double price;
	@Column(name="category")
	private String category;
	@Column(name = "free_delivery")
	private boolean isFreeDelivery;

	public MenuItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItems(String name, boolean isActive, Date dateOfLaunch, double price, String category,
			boolean isFreeDelivery) {
		super();
		this.name = name;
		this.isActive = isActive;
		this.dateOfLaunch = dateOfLaunch;
		this.price=price;
		this.category = category;
		this.isFreeDelivery = isFreeDelivery;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getIsFreeDelivery() {
		return isFreeDelivery;
	}

	public void setIsFreeDelivery(boolean isFreeDelivery) {
		this.isFreeDelivery = isFreeDelivery;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
