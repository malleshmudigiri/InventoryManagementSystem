package com.example.inventorymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagementsystem.model.OrderItem;
public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Long> {
}

