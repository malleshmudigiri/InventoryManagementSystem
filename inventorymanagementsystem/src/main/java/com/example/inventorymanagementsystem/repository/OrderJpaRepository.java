package com.example.inventorymanagementsystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagementsystem.model.Order;



public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
