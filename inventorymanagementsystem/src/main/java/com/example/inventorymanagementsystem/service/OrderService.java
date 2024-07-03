package com.example.inventorymanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.inventorymanagementsystem.model.Order;
import com.example.inventorymanagementsystem.repository.OrderJpaRepository;
import com.example.inventorymanagementsystem.repository.OrderRepository;

@Service
public class OrderService implements OrderRepository {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Override
    public ArrayList<Order> getAllOrders() {
        List<Order> orderList = orderJpaRepository.findAll();
        return new ArrayList<>(orderList);
    }

    @Override
    public Order createOrder(Order order) {
        // Additional business logic (e.g., adjusting stock levels) can be added here
        return orderJpaRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Optional<Order> optionalOrder = orderJpaRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();

            // Update order details based on the provided order object
            if (order.getOrderDate() != null) {
                existingOrder.setOrderDate(order.getOrderDate());
            }
            if (order.getStatus() != null) {
                existingOrder.setStatus(order.getStatus());
            }

            // Update other fields as needed
            return orderJpaRepository.save(existingOrder);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id: " + id);
        }
    }

    @Override
    public void cancelOrder(Long id) {
        Optional<Order> optionalOrder = orderJpaRepository.findById(id);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            // Additional logic to cancel order (e.g., updating status, adjusting stock levels)
            order.setStatus("Canceled");

            // Save the updated order (if necessary)
            orderJpaRepository.save(order);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found with id: " + id);
        }
    }
}
