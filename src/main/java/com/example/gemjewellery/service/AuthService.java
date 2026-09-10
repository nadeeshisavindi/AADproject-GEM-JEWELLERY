package com.example.gemjewellery.service;

import com.example.gemjewellery.dto.AuthDTO;
import com.example.gemjewellery.dto.RegisterDTO;
import com.example.gemjewellery.dto.UserDataDTO;

public interface AuthService {
    UserDataDTO login(AuthDTO authDTO);
    void registerCustomer(RegisterDTO dto);
    void registerStaff(RegisterDTO dto);
}
