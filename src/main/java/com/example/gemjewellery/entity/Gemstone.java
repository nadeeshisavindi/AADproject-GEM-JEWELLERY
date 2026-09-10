package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gemstones")
public class Gemstone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gemstoneId;

    @Column(unique = true, nullable = false)
    private String gemCode;

    private double carat;
    private String shape;
    private String description;


    @ManyToOne
    @JoinColumn(name = "gem_color_id", nullable = false)
    private GemColor gemColor;

    @ManyToOne
    @JoinColumn(name = "gem_origin_id", nullable = false)
    private GemOrigin gemOrigin;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
