package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.dto.OrderRequestDTO;
import com.example.gemjewellery.entity.Order;
import com.example.gemjewellery.repository.CustomerRepository;
import com.example.gemjewellery.repository.JewelleryItemRepository;
import com.example.gemjewellery.repository.OrderItemRepository;
import com.example.gemjewellery.service.OrderService;
import com.example.gemjewellery.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);


    private final OrderService orderService;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final JewelleryItemRepository jewelleryItemRepository;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse placeOrder(@RequestBody OrderRequestDTO request, Authentication authentication) {
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAll()


    @GetMapping(value = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getForCustomer(@PathVariable Long customerId) {


    @PatchMapping(value = "/{orderId}/status", produces = MediaType.APPLICATION_JSON_VALUE)

}
