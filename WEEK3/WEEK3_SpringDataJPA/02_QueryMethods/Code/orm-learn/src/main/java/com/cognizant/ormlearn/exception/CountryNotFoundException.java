package com.cognizant.ormlearn.exception;

public class CountryNotFoundException extends Exception {
    
    public CountryNotFoundException(String message) {
        super(message);
    }
    
    public static CountryNotFoundException withCode(String code) {
        return new CountryNotFoundException("Country not found with code: " + code);
    }
    
    public static CountryNotFoundException withName(String name) {
        return new CountryNotFoundException("Country not found with name: " + name);
    }
} 