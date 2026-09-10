package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gem_origins")
public class GemOrigin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gemOriginId;

    @Column(unique = true, nullable = false)
    private String originName;
}
