package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gem_types")
public class GemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gemTypeId;

    @Column(unique = true, nullable = false)
    private String typeName;
}
