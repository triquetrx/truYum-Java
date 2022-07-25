package com.example.truyum.service;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.truyum.entity.Users;

import lombok.NoArgsConstructor;

@Service
public @NoArgsConstructor class UserLoginService implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	private boolean active;
	

	public UserLoginService(Users user) {
		super();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		this.active = user.isActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}
	
}
