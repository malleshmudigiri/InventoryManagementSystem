package com.example.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagementsystem.model.Item;
import com.example.inventorymanagementsystem.model.Order;
import com.example.inventorymanagementsystem.model.Supplier;
import com.example.inventorymanagementsystem.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * Endpoint to generate and retrieve the stock report.
     * @return List of Items representing the stock report.
     */
    @GetMapping("/stock")
    public List<Item> getStockReport() {
        return reportService.generateStockReport();
    }

    /**
     * Endpoint to generate and retrieve the order report.
     * @return List of Orders representing the order report.
     */
    @GetMapping("/orders")
    public List<Order> getOrderReport() {
        return reportService.generateOrderReport();
    }

    /**
     * Endpoint to generate and retrieve the supplier report.
     * @return List of Suppliers representing the supplier report.
     */
    @GetMapping("/suppliers")
    public List<Supplier> getSupplierReport() {
        return reportService.generateSupplierReport();
    }
}
