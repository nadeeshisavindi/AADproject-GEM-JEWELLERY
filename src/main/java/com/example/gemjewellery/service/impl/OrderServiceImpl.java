package com.example.gemjewellery.service.impl;

import com.example.gemjewellery.dto.OrderItemRequestDTO;
import com.example.gemjewellery.dto.OrderRequestDTO;
import com.example.gemjewellery.entity.Customer;
import com.example.gemjewellery.entity.JewelleryItem;
import com.example.gemjewellery.entity.Order;
import com.example.gemjewellery.entity.OrderItem;
import com.example.gemjewellery.enumiration.OrderStatus;
import com.example.gemjewellery.exception.AppException;
import com.example.gemjewellery.repository.CustomerRepository;
import com.example.gemjewellery.repository.JewelleryItemRepository;
import com.example.gemjewellery.repository.OrderItemRepository;
import com.example.gemjewellery.repository.OrderRepository;
import com.example.gemjewellery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final JewelleryItemRepository jewelleryItemRepository;


    }
}
