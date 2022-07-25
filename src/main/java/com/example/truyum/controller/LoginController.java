package com.example.truyum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.truyum.entity.Users;
import com.example.truyum.service.SignUpService;

@Controller
public class LoginController {
	
	@Autowired
	SignUpService signupService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/signup",method = RequestMethod.GET)
	public String signup(ModelMap model) {
		model.put("newUser", new Users());
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String newAccount(ModelMap model,@ModelAttribute("newUser") @Valid Users user,BindingResult result) {
		if(result.hasErrors()) {
			return "signup";
		}
		signupService.createNewAccount(user.getUserFirstName(), user.getUserLastName(), user.getUsername(), user.getPassword());
		return "redirect:login";
	}
	
}
