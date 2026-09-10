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





}

