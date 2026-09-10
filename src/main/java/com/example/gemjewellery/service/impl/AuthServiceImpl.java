package com.example.gemjewellery.service.impl;

import com.example.gemjewellery.dto.AuthDTO;
import com.example.gemjewellery.dto.RegisterDTO;
import com.example.gemjewellery.dto.UserDataDTO;
import com.example.gemjewellery.entity.Customer;
import com.example.gemjewellery.entity.Role;
import com.example.gemjewellery.entity.User;
import com.example.gemjewellery.enumiration.UserRole;
import com.example.gemjewellery.exception.AppException;
import com.example.gemjewellery.repository.CustomerRepository;
import com.example.gemjewellery.repository.RoleRepository;
import com.example.gemjewellery.repository.UserRepository;
import com.example.gemjewellery.security.JwtUtil;
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
    private final JwtUtil jwtUtil;

    @Override
    public UserDataDTO login(AuthDTO authDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new AppException(401, "Invalid username or password");
        }

        User user = userRepository.findByUsername(authDTO.getUsername())
                .orElseThrow(() -> new AppException(404, "User not found"));

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().getRoleName().name());
        log.info("User '{}' logged in with role {}", user.getUsername(), user.getRole().getRoleName());

        return new UserDataDTO(user.getUserId(), user.getUsername(), user.getRole().getRoleName().name(), token);
    }

    @Override
    public void registerCustomer(RegisterDTO dto) {
        User user = createUserAccount(dto, UserRole.CUSTOMER);

        Customer customer = new Customer();
        customer.setUser(user);
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customerRepository.save(customer);

        log.info("New customer registered: {}", dto.getUsername());
    }

    @Override
    public void registerStaff(RegisterDTO dto) {
        UserRole role;
        try {
            role = UserRole.valueOf(dto.getRoleName().toUpperCase());
        } catch (Exception ex) {
            throw new AppException(400, "roleName must be ADMIN or STAFF");
        }
        if (role == UserRole.CUSTOMER) {
            throw new AppException(400, "Use /register-customer for customer accounts");
        }
        createUserAccount(dto, role);
        log.info("New {} account registered: {}", role, dto.getUsername());
    }

    private User createUserAccount(RegisterDTO dto, UserRole roleName) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new AppException(409, "Username already taken");
        }
        Role role = roleRepository.findAll().stream()
                .filter(r -> r.getRoleName() == roleName)
                .findFirst()
                .orElseThrow(() -> new AppException(500, "Role not seeded: " + roleName));

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(role);
        user.setEnabled(true);
        return userRepository.save(user);
    }
}
