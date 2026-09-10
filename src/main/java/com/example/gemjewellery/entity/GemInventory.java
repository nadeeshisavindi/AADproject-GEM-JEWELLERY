package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gem_inventory")
public class GemInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @OneToOne
    @JoinColumn(name = "gemstone_id", unique = true, nullable = false)
    private Gemstone gemstone;

    private int quantity;
    private String location;
    private LocalDateTime lastUpdated;
}
