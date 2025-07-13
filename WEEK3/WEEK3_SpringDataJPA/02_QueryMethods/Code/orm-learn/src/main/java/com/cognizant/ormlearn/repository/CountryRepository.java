package com.cognizant.ormlearn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // Query Method: Find countries containing text (case-insensitive)
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    
    // Query Method: Find countries starting with specific letter
    List<Country> findByNameStartingWithIgnoreCase(String letter);
    
    // Query Method: Find country by code
    Optional<Country> findById(String code);
    
    // Query Method: Find country by name (case-insensitive)
    Optional<Country> findByNameIgnoreCase(String name);
} 