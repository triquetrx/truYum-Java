package com.example.truyum.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = null;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority auth:authorities) {
			if(auth.getAuthority().equals("ROLE_ADMIN")) {
				url="/menu-item-list-admin";
			} else if(auth.getAuthority().equals("ROLE_USER")){
				url="/";
			}
		}
		if(url==null) {
			throw new IllegalStateException();
		}
		
		new DefaultRedirectStrategy().sendRedirect(request, response, url);
	}

}
