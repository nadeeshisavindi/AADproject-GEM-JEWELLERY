package com.example.gemjewellery.service.impl;

import com.example.gemjewellery.dto.AuthDTO;
import com.example.gemjewellery.dto.RegisterDTO;
import com.example.gemjewellery.dto.UserDataDTO;
import com.example.gemjewellery.entity.Customer;
import com.example.gemjewellery.entity.Role;
import com.example.gemjewellery.entity.User;
import com.example.gemjewellery.repository.CustomerRepository;
import com.example.gemjewellery.repository.RoleRepository;
import com.example.gemjewellery.repository.UserRepository;
import com.example.gemjewellery.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDataDTO login(AuthDTO authDTO) {
      }

    @Override
    public void registerCustomer(RegisterDTO dto) {

        Customer customer = new Customer();
      }


}
