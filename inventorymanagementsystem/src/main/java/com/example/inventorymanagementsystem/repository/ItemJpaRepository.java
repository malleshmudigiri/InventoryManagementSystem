package com.example.inventorymanagementsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagementsystem.model.Item;

public interface ItemJpaRepository extends JpaRepository<Item, Long> {
}
