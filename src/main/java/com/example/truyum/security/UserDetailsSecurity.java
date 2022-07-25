package com.example.truyum.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.truyum.entity.Users;
import com.example.truyum.repository.UserRepository;
import com.example.truyum.service.UserLoginService;

@Service
public class UserDetailsSecurity implements UserDetailsService{
	
	@Autowired
	UserRepository users;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> user = users.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("User Doesn't exist"));
		return user.map(UserLoginService::new).get();
	}
	
}
