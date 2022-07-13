package com.example.truyum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.truyum.entity.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems, Long> {

}
