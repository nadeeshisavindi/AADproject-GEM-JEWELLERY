package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jewellery_items")
public class JewelleryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(unique = true, nullable = false)
    private String itemCode;

    private String itemName;
    private String metalType;
    private double weight;
    private double price;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private JewelleryCategory category;

     @ManyToOne
    @JoinColumn(name = "gemstone_id")
    private Gemstone gemstone;
}
