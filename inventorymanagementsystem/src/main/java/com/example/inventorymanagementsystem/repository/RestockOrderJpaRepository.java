package com.example.inventorymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagementsystem.model.RestockOrder;

public interface RestockOrderJpaRepository extends JpaRepository<RestockOrder, Long> {
}

