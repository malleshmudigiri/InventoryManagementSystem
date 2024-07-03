package com.example.inventorymanagementsystem.repository;




import java.util.ArrayList;

import com.example.inventorymanagementsystem.model.Order;



public interface OrderRepository {
    ArrayList<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void cancelOrder(Long id);

}

