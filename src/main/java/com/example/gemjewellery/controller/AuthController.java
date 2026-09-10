package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.AuthDTO;
import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.dto.RegisterDTO;
import com.example.gemjewellery.dto.UserDataDTO;
import com.example.gemjewellery.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse login(@RequestBody AuthDTO authDTO) {
        UserDataDTO data = authService.login(authDTO);
        return new CommonResponse(0, data, "Login successful");
    }


    @PostMapping(value = "/register-customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse registerCustomer(@RequestBody RegisterDTO dto) {
        authService.registerCustomer(dto);
        return new CommonResponse(0, "Customer account created. You can now log in.");
    }

    @PostMapping(value = "/register-staff", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse registerStaff(@RequestBody RegisterDTO dto) {
        authService.registerStaff(dto);
        return new CommonResponse(0, "Staff/Admin account created");
    }
}
