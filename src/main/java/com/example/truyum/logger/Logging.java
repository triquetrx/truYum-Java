package com.example.truyum.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.truyum.controller.CustomerPageController;

@Aspect
public class Logging {
	
	
	@After("execution(* com.example.truyum.controller.AddToCartRequest(..))")
	public void addedToCart(JoinPoint point) {
		Logger log = LoggerFactory.getLogger(CustomerPageController.class);
		log.info("New Item Added to the cart");
	}
	
}
