package com.example.inventorymanagementsystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagementsystem.model.Order;
import com.example.inventorymanagementsystem.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ArrayList<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{orderId}")
    public Order updateOrder(@PathVariable("orderId") Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void cancelOrder(@PathVariable("orderId") Long id) {
        orderService.cancelOrder(id);
    }
}
