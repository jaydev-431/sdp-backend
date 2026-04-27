package com.klef.sdp.sdpbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.*;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            // ❌ Disable CSRF (important for REST APIs)
            .csrf(csrf -> csrf.disable())

            // 🔐 AUTH RULES
            .authorizeHttpRequests(auth -> auth

                // ================= PUBLIC (NO LOGIN REQUIRED) =================
                .requestMatchers("/authlogin/**").permitAll()
                .requestMatchers("/citizen_api/citizenregister").permitAll()
                .requestMatchers("/citizen_api/login").permitAll()

                // ================= ROLE BASED =================
                .requestMatchers("/admin_api/**").hasRole("ADMIN")
                .requestMatchers("/citizen_api/**").hasRole("CITIZEN")
                .requestMatchers("/analystapi/**").hasRole("ANALYST")
                .requestMatchers("/observer_api/**").hasRole("OBSERVER")

                // ================= EVERYTHING ELSE =================
                .anyRequest().authenticated()
            )

            
            .sessionManagement(sess ->
                sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}