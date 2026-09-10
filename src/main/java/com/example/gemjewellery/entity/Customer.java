package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;


    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private String fullName;
    private String email;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
}
