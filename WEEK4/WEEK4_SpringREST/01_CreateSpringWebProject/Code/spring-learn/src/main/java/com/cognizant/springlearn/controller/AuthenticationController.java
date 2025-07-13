package com.cognizant.springlearn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Base64;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START");
        LOGGER.debug("Authorization header: {}", authHeader);
        
        Map<String, String> response = new HashMap<>();
        String user = getUser(authHeader);
        String token = generateJwt(user);
        
        response.put("token", token);
        
        LOGGER.info("END");
        return response;
    }

    private String getUser(String authHeader) {
        LOGGER.debug("START");
        String encodedCredentials = authHeader.substring(6); // Remove "Basic "
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        String user = credentials.split(":")[0];
        LOGGER.debug("User: {}", user);
        LOGGER.debug("END");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.debug("START");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000)); // 20 minutes
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        
        String token = builder.compact();
        LOGGER.debug("Generated token: {}", token);
        LOGGER.debug("END");
        return token;
    }
} 