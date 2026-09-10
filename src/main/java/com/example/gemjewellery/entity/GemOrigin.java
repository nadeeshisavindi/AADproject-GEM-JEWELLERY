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
  private String originName; // e.g. Sri Lanka, Myanmar, Colombia
}
