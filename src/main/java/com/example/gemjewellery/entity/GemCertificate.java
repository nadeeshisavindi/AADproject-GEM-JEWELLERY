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
@Table(name = "gem_certificates")
public class GemCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificateId;

    @OneToOne
    @JoinColumn(name = "gemstone_id", unique = true, nullable = false)
    private Gemstone gemstone;

    private String certificateNumber;
    private String issuingAuthority;
    private LocalDate issueDate;
}
