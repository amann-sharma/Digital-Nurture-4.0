package com.cognizant.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
        
        // Load Spring XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Get Country bean from XML configuration
        Country country = (Country) context.getBean("country");
        
        System.out.println("Country loaded from XML configuration:");
        System.out.println("Code: " + country.getCode());
        System.out.println("Name: " + country.getName());
        System.out.println("Population: " + country.getPopulation());
    }
} 