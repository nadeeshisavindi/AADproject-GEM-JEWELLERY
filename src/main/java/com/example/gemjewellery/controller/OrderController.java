package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.dto.OrderRequestDTO;
import com.example.gemjewellery.entity.Order;
import com.example.gemjewellery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse placeOrder(@RequestBody OrderRequestDTO request, Authentication authentication) {
       }

}
