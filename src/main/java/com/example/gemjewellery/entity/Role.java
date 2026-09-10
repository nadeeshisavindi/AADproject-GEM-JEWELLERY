package com.example.gemjewellery.entity;


import com.example.gemjewellery.enumiration.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;


    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private UserRole roleName;


}
