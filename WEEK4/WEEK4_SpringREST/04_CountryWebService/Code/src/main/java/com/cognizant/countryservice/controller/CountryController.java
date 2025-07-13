package com.cognizant.countryservice.controller;

import com.cognizant.countryservice.Country;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
    
    private List<Country> countries;
    
    public CountryController() {
        countries = new ArrayList<>();
        countries.add(new Country("IN", "India", "1380004385"));
        countries.add(new Country("US", "United States", "331002651"));
        countries.add(new Country("CN", "China", "1439323776"));
        countries.add(new Country("JP", "Japan", "126476461"));
        countries.add(new Country("DE", "Germany", "83783942"));
    }
    
    @GetMapping
    public List<Country> getAllCountries() {
        return countries;
    }
    
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
    
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        countries.add(country);
        return country;
    }
    
    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable String code, @RequestBody Country country) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equalsIgnoreCase(code)) {
                countries.set(i, country);
                return country;
            }
        }
        return null;
    }
    
    @DeleteMapping("/{code}")
    public boolean deleteCountry(@PathVariable String code) {
        return countries.removeIf(country -> country.getCode().equalsIgnoreCase(code));
    }
} 