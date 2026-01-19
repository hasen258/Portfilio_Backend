package com.protfilo.demo.controller;

import com.protfilo.demo.dto.LoginRequest;
import com.protfilo.demo.dto.LoginResponse;
import com.protfilo.demo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Value("${DASHBOARD_USER}")
    private String adminUsername;

    @Value("${DASHBOARD_PASS}")
    private String adminPassword;

    private final JwtUtils jwtUtils;

    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (!adminUsername.equals(request.getUsername())
                || !adminPassword.equals(request.getPassword())) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }

        String token = jwtUtils.generateToken(request.getUsername());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
