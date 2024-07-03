package com.example.inventorymanagementsystem.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inventorymanagementsystem.model.Supplier;



public interface SupplierJpaRepository extends JpaRepository<Supplier, Long> {
}