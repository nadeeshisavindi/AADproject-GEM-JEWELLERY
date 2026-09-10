package com.example.gemjewellery.entity;


import com.example.gemjewellery.enumiration.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private LocalDateTime orderDate = LocalDateTime.now();


    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    private double totalAmount;


}
