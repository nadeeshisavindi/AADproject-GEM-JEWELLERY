package com.example.gemjewellery.config;

import com.example.gemjewellery.entity.Customer;
import com.example.gemjewellery.entity.Role;
import com.example.gemjewellery.entity.User;

import com.example.gemjewellery.enumiration.UserRole;
import com.example.gemjewellery.repository.CustomerRepository;
import com.example.gemjewellery.repository.RoleRepository;
import com.example.gemjewellery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


        seedUser("admin", "admin123", UserRole.ADMIN);
        seedUser("staff1", "staff123", UserRole.STAFF);
        User customerUser = seedUser("customer1", "customer123", UserRole.CUSTOMER);

         if (customerUser != null && customerRepository.findByUser_Username("customer1").isEmpty()) {
            Customer customer = new Customer();
            customer.setUser(customerUser);
            customer.setFullName("Demo Customer");
            customer.setEmail("customer1@example.com");
            customer.setPhone("0771234567");
            customer.setAddress("Colombo, Sri Lanka");
            customerRepository.save(customer);
            log.info("Seeded demo customer profile for customer1");
        }

    }

    private User seedUser(String username, String rawPassword, UserRole roleName) {

    }
}

