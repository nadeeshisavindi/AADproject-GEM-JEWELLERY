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
    public CommonResponse getMyProfile(Authentication authentication) {
        Customer customer = customerRepository.findByUser_Username(authentication.getName())
                .orElseThrow(() -> new AppException(404, "No customer profile linked to this account"));
        return new CommonResponse(0, customer, "My profile");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAll(@RequestParam(required = false) String search) {
        if (search != null && !search.isBlank()) {
            return new CommonResponse(0, customerRepository.findByFullNameContainingIgnoreCase(search), "Customers");
        }
        return new CommonResponse(0, customerRepository.findAll(), "Customers");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getOne(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException(404, "Customer not found"));
        return new CommonResponse(0, customer, "Customer");
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse update(@RequestBody Customer customer) {
        if (!customerRepository.existsById(customer.getCustomerId())) {
            throw new AppException(404, "Customer not found");
        }
        return new CommonResponse(0, customerRepository.save(customer), "Customer updated");
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return new CommonResponse(0, "Customer deleted");
    }
}
