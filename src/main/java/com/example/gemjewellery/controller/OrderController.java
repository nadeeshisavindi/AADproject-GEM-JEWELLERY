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
        Order order = orderService.placeOrder(authentication.getName(), request);
        return new CommonResponse(0, order, "Order placed successfully");
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAll() {

        return new CommonResponse(0, orderService.getAllOrders(), "All orders");
    }


    @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getForCustomer(@PathVariable Long customerId) {
        return new CommonResponse(0, orderService.getOrdersForCustomer(customerId), "Customer orders");
    }


    @PatchMapping(value = "/{orderId}/status", produces = MediaType.APPLICATION_JSON_VALUE)

}
