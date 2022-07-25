package com.example.truyum.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	LoginHandler login;
	@Autowired
	UserDetailsSecurity userData;
	

	Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Bean
	protected SecurityFilterChain filter(HttpSecurity https) throws Exception{
		
		https.authorizeRequests()
		.antMatchers("/").hasRole("USER")
		.antMatchers("/cart").hasRole("USER")
		.antMatchers("/menu-item-list-admin").hasRole("ADMIN")
		.antMatchers("/edit-admin").hasRole("ADMIN")
		.antMatchers("/add-admin-items").hasRole("ADMIN")
		.antMatchers("/login").permitAll()
		.and().formLogin().loginPage("/login").successHandler(login)
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		return https.build();
	}
	
	protected void config(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userData);
	}
	
	@Bean
	protected PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
