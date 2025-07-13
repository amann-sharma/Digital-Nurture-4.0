package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Country;

@Component
public class CountryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);

    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = new Country("IN", "India");
        LOGGER.info("END");
        return country;
    }

    public List<Country> getAllCountries() {
        LOGGER.info("START");
        // This would typically load from XML configuration
        // For now, returning hardcoded list
        List<Country> countries = List.of(
            new Country("IN", "India"),
            new Country("US", "United States"),
            new Country("DE", "Germany"),
            new Country("JP", "Japan")
        );
        LOGGER.info("END");
        return countries;
    }

    public Country getCountry(String code) {
        LOGGER.info("START");
        List<Country> countries = getAllCountries();
        Country foundCountry = countries.stream()
            .filter(country -> country.getCode().equalsIgnoreCase(code))
            .findFirst()
            .orElse(null);
        LOGGER.info("END");
        return foundCountry;
    }
} 