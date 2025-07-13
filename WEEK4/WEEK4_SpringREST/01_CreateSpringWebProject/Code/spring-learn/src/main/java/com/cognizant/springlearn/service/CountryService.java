package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryDao countryDao;

    @Transactional
    public Country getCountryIndia() {
        LOGGER.info("START");
        Country country = countryDao.getCountryIndia();
        LOGGER.info("END");
        return country;
    }

    @Transactional
    public List<Country> getAllCountries() {
        LOGGER.info("START");
        List<Country> countries = countryDao.getAllCountries();
        LOGGER.info("END");
        return countries;
    }

    @Transactional
    public Country getCountry(String code) {
        LOGGER.info("START");
        Country country = countryDao.getCountry(code);
        if (country == null) {
            throw new CountryNotFoundException();
        }
        LOGGER.info("END");
        return country;
    }
} 