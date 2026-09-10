package com.example.gemjewellery.controller;

import com.example.gemjewellery.dto.CommonResponse;
import com.example.gemjewellery.entity.Customer;
import com.example.gemjewellery.exception.AppException;
import com.example.gemjewellery.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    // lets a logged-in customer find their own customerId (needed to place/view their own orders)
    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAll(@RequestParam(required = false) String search) {


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getOne(@PathVariable Long id)

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse update(@RequestBody Customer customer)

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new CommonResponse(0, "Customer deleted");
    }
}
