package com.example.truyum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
public @NoArgsConstructor @Data class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@Size(min = 3, message = "Minimum 3 characters required")
	private String userFirstName;
	private String userLastName;
	@Size(min = 4,message = "Minimum 4 characters required")
	private String username;
	@Size(min=8,message="Minimum 8 characters required")
	private String password;
	private boolean active;
	private String roles;
	
	public Users(String userFirstName, String userLastName, String username, String password, boolean active,
			String roles) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
	
	
}
