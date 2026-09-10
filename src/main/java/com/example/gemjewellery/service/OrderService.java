package com.example.gemjewellery.service;

import com.example.gemjewellery.dto.OrderRequestDTO;
import com.example.gemjewellery.entity.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(String loggedInUsername, OrderRequestDTO request);
    List<Order> getAllOrders();
    List<Order> getOrdersForCustomer(Long customerId);
    Order updateStatus(Long orderId, String status);
}
