package com.example.gemjewellery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String username;
    private String password;
    private String roleName; // ADMIN / STAFF / CUSTOMER


    private String fullName;
    private String email;
    private String phone;
    private String address;
}
