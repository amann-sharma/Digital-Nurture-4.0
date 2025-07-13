package com.cognizant.countrycode.controller;

import com.cognizant.countrycode.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    
    private Map<String, Country> countries;
    
    public CountryController() {
        countries = new HashMap<>();
        countries.put("IN", new Country("IN", "India", "1380004385"));
        countries.put("US", new Country("US", "United States", "331002651"));
        countries.put("CN", new Country("CN", "China", "1439323776"));
        countries.put("JP", new Country("JP", "Japan", "126476461"));
        countries.put("DE", new Country("DE", "Germany", "83783942"));
        countries.put("GB", new Country("GB", "United Kingdom", "67886011"));
        countries.put("FR", new Country("FR", "France", "65273511"));
        countries.put("IT", new Country("IT", "Italy", "60461826"));
        countries.put("CA", new Country("CA", "Canada", "37742154"));
        countries.put("AU", new Country("AU", "Australia", "25499884"));
    }
    
    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountryByCode(@PathVariable String code) {
        Country country = countries.get(code.toUpperCase());
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<Country> searchCountry(@RequestParam String code) {
        Country country = countries.get(code.toUpperCase());
        if (country != null) {
            return ResponseEntity.ok(country);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 