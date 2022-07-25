package com.example.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.truyum.entity.Users;
import com.example.truyum.repository.UserRepository;

@Service
public class SignUpService {

	@Autowired
	UserRepository userRepo;
	
	public void createNewAccount(String firstName,String lastName,String username,String password) {
		Users user = new Users(firstName, lastName==null?"LNU":lastName, 
				username, passwordEncoder().encode(password), true, "ROLE_USER");
		
		userRepo.save(user);
	}
	
	
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
