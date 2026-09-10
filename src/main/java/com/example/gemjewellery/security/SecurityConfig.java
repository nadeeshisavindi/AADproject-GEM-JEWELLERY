package com.example.gemjewellery.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/", "/index.html",
                                "/login.html", "/css/**", "/js/**", "/images/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/v1/auth/login",
                                "/v1/auth/register-customer").permitAll()


                        .requestMatchers(HttpMethod.GET, "/v1/jewellery-items/**", "/v1/gem-types/**",
                                "/v1/gem-colors/**", "/v1/gem-origins/**", "/v1/categories/**").permitAll()

                         .requestMatchers(HttpMethod.GET, "/v1/customers/me", "/v1/orders/customer/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/v1/orders").authenticated()


                        .requestMatchers("/v1/auth/register-staff").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/v1/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST, "/v1/gemstones/**", "/v1/jewellery-items/**",
                                "/v1/gem-types/**", "/v1/gem-colors/**", "/v1/gem-origins/**",
                                "/v1/categories/**", "/v1/suppliers/**").hasAnyRole("ADMIN", "STAFF")

                        .requestMatchers(HttpMethod.PUT, "/v1/gemstones/**", "/v1/jewellery-items/**",
                                "/v1/suppliers/**", "/v1/customers/**").hasAnyRole("ADMIN", "STAFF")

                        .requestMatchers(HttpMethod.PATCH, "/v1/orders/**").hasAnyRole("ADMIN", "STAFF")

                        .requestMatchers(HttpMethod.GET, "/v1/customers/**").hasAnyRole("ADMIN", "STAFF")

                        .requestMatchers(HttpMethod.GET, "/v1/orders").hasAnyRole("ADMIN", "STAFF")
                        .requestMatchers(HttpMethod.GET, "/v1/suppliers/**").hasAnyRole("ADMIN", "STAFF")


                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())

                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(passwordEncoder());
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}