package com.example.inventorymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventorymanagementsystem.model.Item;
import com.example.inventorymanagementsystem.model.Order;
import com.example.inventorymanagementsystem.model.Supplier;
import com.example.inventorymanagementsystem.repository.ItemJpaRepository;
import com.example.inventorymanagementsystem.repository.OrderJpaRepository;
import com.example.inventorymanagementsystem.repository.SupplierJpaRepository;

@Service
public class ReportService {

    @Autowired
    private ItemJpaRepository itemJpaRepository;

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    private SupplierJpaRepository supplierJpaRepository;

    /**
     * Generates a report of all items in the inventory.
     * 
     * @return List of items representing the stock report.
     */
    public List<Item> generateStockReport() {
        return itemJpaRepository.findAll();
    }

    /**
     * Generates a report of all orders.
     * 
     * @return List of orders representing the order report.
     */
    public List<Order> generateOrderReport() {
        return orderJpaRepository.findAll();
    }

    /**
     * Generates a report of all suppliers.
     * 
     * @return List of suppliers representing the supplier report.
     */
    public List<Supplier> generateSupplierReport() {
        return supplierJpaRepository.findAll();
    }
}
