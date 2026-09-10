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

    @Override
    @Transactional
    public Order placeOrder(String loggedInUsername, OrderRequestDTO request) {
        Customer customer;
        if (request.getCustomerId() != null) {
            customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new AppException(404, "Customer not found"));
        } else {
            customer = customerRepository.findByUser_Username(loggedInUsername)
                    .orElseThrow(() -> new AppException(404, "No customer profile linked to this account"));
        }

        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new AppException(400, "Order must contain at least one item");
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.PENDING);
        Order savedOrder = orderRepository.save(order); // save first to get an order_id for the line items

        double total = 0;
        for (OrderItemRequestDTO line : request.getItems()) {
            JewelleryItem item = jewelleryItemRepository.findById(line.getItemId())
                    .orElseThrow(() -> new AppException(404, "Jewellery item not found: " + line.getItemId()));

            if (line.getQuantity() <= 0) {
                throw new AppException(400, "Quantity must be greater than zero");
            }
            if (item.getStockQuantity() < line.getQuantity()) {
                throw new AppException(409, "Not enough stock for " + item.getItemName());
            }

            item.setStockQuantity(item.getStockQuantity() - line.getQuantity());
            jewelleryItemRepository.save(item);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setJewelleryItem(item);
            orderItem.setQuantity(line.getQuantity());
            orderItem.setUnitPrice(item.getPrice());
            orderItem.setSubtotal(item.getPrice() * line.getQuantity());
            orderItemRepository.save(orderItem);

            total += orderItem.getSubtotal();
        }
        savedOrder.setTotalAmount(total);
        Order saved = orderRepository.save(savedOrder);
        log.info("Order #{} placed for customer {} - total {}", saved.getOrderId(), customer.getCustomerId(), total);
        return saved;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersForCustomer(Long customerId) {
        return orderRepository.findByCustomer_CustomerId(customerId);
    }

    @Override
    public Order updateStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(404, "Order not found"));
        try {
            order.setStatus(OrderStatus.valueOf(status.toUpperCase()));
        } catch (Exception ex) {
            throw new AppException(400, "Invalid status. Use PENDING, CONFIRMED, DELIVERED or CANCELLED");
        }
        return orderRepository.save(order);
    }
}
