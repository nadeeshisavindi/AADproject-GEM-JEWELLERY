package com.example.gemjewellery.repository;

import com.example.gemjewellery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUser_Username(String username);
    List<Customer> findByFullNameContainingIgnoreCase(String fullName);
}
