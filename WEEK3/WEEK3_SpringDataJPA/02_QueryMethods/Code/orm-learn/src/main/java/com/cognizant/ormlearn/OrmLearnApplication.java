package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.StockService;

public class OrmLearnApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static StockService stockService;
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);
        
        LOGGER.info("Inside main");
        
        // Test Country Query Methods
        testGetAllCountries();
        testFindCountryByCode();
        testFindCountriesContainingText();
        testFindCountriesStartingWith();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        
        // Test Stock Query Methods
        testStockQueryMethods();
    }
    
    private static void testGetAllCountries() {
        LOGGER.info("=== Testing GetAllCountries ===");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }
    
    private static void testFindCountryByCode() {
        LOGGER.info("=== Testing FindCountryByCode ===");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
    
    private static void testFindCountriesContainingText() {
        LOGGER.info("=== Testing FindCountriesContainingText ===");
        List<Country> countries = countryService.findCountriesContainingText("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End");
    }
    
    private static void testFindCountriesStartingWith() {
        LOGGER.info("=== Testing FindCountriesStartingWith ===");
        List<Country> countries = countryService.findCountriesStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End");
    }
    
    private static void testAddCountry() {
        LOGGER.info("=== Testing AddCountry ===");
        Country newCountry = new Country("SG", "Singapore");
        countryService.addCountry(newCountry);
        LOGGER.debug("Added country: {}", newCountry);
        LOGGER.info("End");
    }
    
    private static void testUpdateCountry() {
        LOGGER.info("=== Testing UpdateCountry ===");
        countryService.updateCountry("IN", "India Updated");
        LOGGER.debug("Updated country IN");
        LOGGER.info("End");
    }
    
    private static void testDeleteCountry() {
        LOGGER.info("=== Testing DeleteCountry ===");
        countryService.deleteCountry("SG");
        LOGGER.debug("Deleted country SG");
        LOGGER.info("End");
    }
    
    private static void testStockQueryMethods() {
        LOGGER.info("=== Testing Stock Query Methods ===");
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2019-09-01");
            Date endDate = sdf.parse("2019-09-30");
            
            // Test Facebook stocks in September 2019
            List<Stock> facebookStocks = stockService.findFacebookStocksInSeptember(startDate, endDate);
            LOGGER.debug("Facebook stocks in September 2019: {}", facebookStocks);
            
            // Test Google stocks above 1250
            List<Stock> googleStocks = stockService.findGoogleStocksAbovePrice(1250.0);
            LOGGER.debug("Google stocks above 1250: {}", googleStocks);
            
            // Test top 3 by volume
            List<Stock> topVolumeStocks = stockService.findTop3ByVolume();
            LOGGER.debug("Top 3 stocks by volume: {}", topVolumeStocks);
            
            // Test Netflix lowest prices
            List<Stock> netflixStocks = stockService.findNetflixStocksByLowestPrice();
            LOGGER.debug("Netflix stocks by lowest price: {}", netflixStocks);
            
        } catch (Exception e) {
            LOGGER.error("Error testing stock queries: {}", e.getMessage());
        }
        
        LOGGER.info("End");
    }
} 