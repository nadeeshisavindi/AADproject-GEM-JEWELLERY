package com.example.gemjewellery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gem_valuations")
public class GemValuation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long valuationId;

    @ManyToOne
    @JoinColumn(name = "gemstone_id", nullable = false)
    private Gemstone gemstone;

    private double valuedPrice;
    private LocalDate valuationDate;
    private String valuedBy;
}
