package com.cognizant.springcore;

public class Country {
    private String code;
    private String name;
    private String population;
    
    public Country() {}
    
    public Country(String code, String name, String population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPopulation() {
        return population;
    }
    
    public void setPopulation(String population) {
        this.population = population;
    }
    
    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
} 