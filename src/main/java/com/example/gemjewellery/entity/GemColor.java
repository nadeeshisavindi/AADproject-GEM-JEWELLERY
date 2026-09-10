package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gem_colors")
public class GemColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gemColorId;

    @Column(unique = true, nullable = false)
    private String colorName;
}
