package com.cognizant.jwt.controller;

import com.cognizant.jwt.model.LoginRequest;
import com.cognizant.jwt.model.LoginResponse;
import com.cognizant.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private JwtService jwtService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Simple authentication - in real application, validate against database
        if ("admin".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            String token = jwtService.generateToken(loginRequest.getUsername());
            LoginResponse response = new LoginResponse(token, "Login successful");
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse(null, "Invalid credentials");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                String username = jwtService.extractUsername(token);
                if (jwtService.isTokenValid(token, username)) {
                    return ResponseEntity.ok("Token is valid for user: " + username);
                } else {
                    return ResponseEntity.badRequest().body("Token is invalid or expired");
                }
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Invalid token");
            }
        }
        return ResponseEntity.badRequest().body("No token provided");
    }
    
    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        return ResponseEntity.ok("This is a public endpoint - no authentication required");
    }
    
    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                String username = jwtService.extractUsername(token);
                if (jwtService.isTokenValid(token, username)) {
                    return ResponseEntity.ok("Welcome to protected endpoint, " + username + "!");
                }
            } catch (Exception e) {
                // Token validation failed
            }
        }
        return ResponseEntity.status(401).body("Access denied - valid token required");
    }
} 