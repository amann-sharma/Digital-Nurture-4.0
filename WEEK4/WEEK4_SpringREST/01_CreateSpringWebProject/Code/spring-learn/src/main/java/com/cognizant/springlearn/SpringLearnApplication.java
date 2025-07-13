package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END");
    }

    // Hands-on 2: Load SimpleDateFormat from Spring Configuration XML
    public void displayDate() {
        LOGGER.info("START");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
            SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date: {}", e.getMessage());
        }
        LOGGER.info("END");
    }

    // Hands-on 4: Load Country from Spring Configuration XML
    public void displayCountry() {
        LOGGER.info("START");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
            Country country = context.getBean("country", Country.class);
            LOGGER.debug("Country : {}", country.toString());
        } catch (Exception e) {
            LOGGER.error("Error loading country: {}", e.getMessage());
        }
        LOGGER.info("END");
    }

    // Hands-on 6: Load list of countries from Spring Configuration XML
    public void displayCountries() {
        LOGGER.info("START");
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
            @SuppressWarnings("unchecked")
            List<Country> countries = context.getBean("countryList", List.class);
            LOGGER.debug("Countries: {}", countries);
        } catch (Exception e) {
            LOGGER.error("Error loading countries: {}", e.getMessage());
        }
        LOGGER.info("END");
    }
} 