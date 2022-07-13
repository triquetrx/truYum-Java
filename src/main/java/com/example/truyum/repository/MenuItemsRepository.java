package com.example.truyum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.truyum.entity.MenuItems;

public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {

}
