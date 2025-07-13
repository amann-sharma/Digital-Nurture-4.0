package com.cognizant.criteria;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.criteria.model.Department;
import com.cognizant.criteria.model.Employee;
import com.cognizant.criteria.service.DepartmentService;
import com.cognizant.criteria.service.EmployeeService;

public class CriteriaApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CriteriaApplication.class);
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CriteriaApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        
        LOGGER.info("Inside main");
        
        // Test Basic Criteria Queries
        testBasicCriteriaQueries();
        
        // Test Advanced Criteria Queries
        testAdvancedCriteriaQueries();
        
        // Test Complex Criteria Queries
        testComplexCriteriaQueries();
    }
    
    private static void testBasicCriteriaQueries() {
        LOGGER.info("=== Testing Basic Criteria Queries ===");
        
        // Test getAllEmployees
        LOGGER.info("--- Testing getAllEmployees ---");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("All Employees: {}", employees);
        
        // Test getAllPermanentEmployees
        LOGGER.info("--- Testing getAllPermanentEmployees ---");
        List<Employee> permanentEmployees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", permanentEmployees);
        
        // Test getEmployeesBySalaryRange
        LOGGER.info("--- Testing getEmployeesBySalaryRange ---");
        List<Employee> employeesInRange = employeeService.getEmployeesBySalaryRange(70000.0, 90000.0);
        LOGGER.debug("Employees with salary between 70000-90000: {}", employeesInRange);
        
        // Test getEmployeesByNamePattern
        LOGGER.info("--- Testing getEmployeesByNamePattern ---");
        List<Employee> employeesByName = employeeService.getEmployeesByNamePattern("John");
        LOGGER.debug("Employees with name containing 'John': {}", employeesByName);
        
        // Test getEmployeesByDepartment
        LOGGER.info("--- Testing getEmployeesByDepartment ---");
        List<Employee> employeesByDept = employeeService.getEmployeesByDepartment(1);
        LOGGER.debug("Employees in Department 1: {}", employeesByDept);
        
        // Test getEmployeesWithSalaryGreaterThan
        LOGGER.info("--- Testing getEmployeesWithSalaryGreaterThan ---");
        List<Employee> employeesWithHighSalary = employeeService.getEmployeesWithSalaryGreaterThan(80000.0);
        LOGGER.debug("Employees with salary > 80000: {}", employeesWithHighSalary);
        
        // Test getEmployeesWithSalaryLessThan
        LOGGER.info("--- Testing getEmployeesWithSalaryLessThan ---");
        List<Employee> employeesWithLowSalary = employeeService.getEmployeesWithSalaryLessThan(70000.0);
        LOGGER.debug("Employees with salary < 70000: {}", employeesWithLowSalary);
        
        LOGGER.info("=== Basic Criteria Queries Testing Complete ===");
    }
    
    private static void testAdvancedCriteriaQueries() {
        LOGGER.info("=== Testing Advanced Criteria Queries ===");
        
        // Test getEmployeesByDateOfBirthRange
        LOGGER.info("--- Testing getEmployeesByDateOfBirthRange ---");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("1985-01-01");
            Date endDate = sdf.parse("1990-12-31");
            List<Employee> employeesByDate = employeeService.getEmployeesByDateOfBirthRange(startDate, endDate);
            LOGGER.debug("Employees born between 1985-1990: {}", employeesByDate);
        } catch (Exception e) {
            LOGGER.error("Error parsing date: {}", e.getMessage());
        }
        
        // Test getEmployeesOrderedBySalary
        LOGGER.info("--- Testing getEmployeesOrderedBySalary ---");
        List<Employee> employeesBySalary = employeeService.getEmployeesOrderedBySalary();
        LOGGER.debug("Employees ordered by salary (desc): {}", employeesBySalary);
        
        // Test getEmployeesOrderedByName
        LOGGER.info("--- Testing getEmployeesOrderedByName ---");
        List<Employee> employeesByNameOrder = employeeService.getEmployeesOrderedByName();
        LOGGER.debug("Employees ordered by name: {}", employeesByNameOrder);
        
        // Test getEmployeesWithNullConditions
        LOGGER.info("--- Testing getEmployeesWithNullConditions ---");
        List<Employee> employeesWithNull = employeeService.getEmployeesWithNullConditions();
        LOGGER.debug("Employees with null date of birth: {}", employeesWithNull);
        
        // Test getEmployeesWithNotNullConditions
        LOGGER.info("--- Testing getEmployeesWithNotNullConditions ---");
        List<Employee> employeesWithNotNull = employeeService.getEmployeesWithNotNullConditions();
        LOGGER.debug("Employees with not null date of birth: {}", employeesWithNotNull);
        
        LOGGER.info("=== Advanced Criteria Queries Testing Complete ===");
    }
    
    private static void testComplexCriteriaQueries() {
        LOGGER.info("=== Testing Complex Criteria Queries ===");
        
        // Test getEmployeesWithComplexConditions
        LOGGER.info("--- Testing getEmployeesWithComplexConditions ---");
        List<Employee> employeesWithComplex = employeeService.getEmployeesWithComplexConditions(70000.0, 90000.0, true, 1);
        LOGGER.debug("Employees with complex conditions: {}", employeesWithComplex);
        
        // Test getEmployeesWithOrConditions
        LOGGER.info("--- Testing getEmployeesWithOrConditions ---");
        List<Employee> employeesWithOr = employeeService.getEmployeesWithOrConditions(75000.0, 80000.0, 1, 2);
        LOGGER.debug("Employees with OR conditions: {}", employeesWithOr);
        
        // Test getEmployeesWithNotConditions
        LOGGER.info("--- Testing getEmployeesWithNotConditions ---");
        List<Employee> employeesWithNot = employeeService.getEmployeesWithNotConditions(75000.0, 1);
        LOGGER.debug("Employees with NOT conditions: {}", employeesWithNot);
        
        // Test getEmployeesWithInConditions
        LOGGER.info("--- Testing getEmployeesWithInConditions ---");
        List<Double> salaries = Arrays.asList(75000.0, 80000.0, 85000.0);
        List<Integer> departmentIds = Arrays.asList(1, 2);
        List<Employee> employeesWithIn = employeeService.getEmployeesWithInConditions(salaries, departmentIds);
        LOGGER.debug("Employees with IN conditions: {}", employeesWithIn);
        
        LOGGER.info("=== Complex Criteria Queries Testing Complete ===");
    }
} 