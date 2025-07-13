package com.cognizant.hqlnative;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.hqlnative.model.Department;
import com.cognizant.hqlnative.model.Employee;
import com.cognizant.hqlnative.service.DepartmentService;
import com.cognizant.hqlnative.service.EmployeeService;

public class HqlNativeApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HqlNativeApplication.class);
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HqlNativeApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        
        LOGGER.info("Inside main");
        
        // Test HQL Queries
        testHqlQueries();
        
        // Test Native Queries
        testNativeQueries();
        
        // Test Advanced Native Queries
        testAdvancedNativeQueries();
    }
    
    private static void testHqlQueries() {
        LOGGER.info("=== Testing HQL Queries ===");
        
        // Test getAllEmployees
        LOGGER.info("--- Testing getAllEmployees ---");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("All Employees: {}", employees);
        
        // Test getAllPermanentEmployees
        LOGGER.info("--- Testing getAllPermanentEmployees ---");
        List<Employee> permanentEmployees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", permanentEmployees);
        
        // Test getAverageSalary
        LOGGER.info("--- Testing getAverageSalary ---");
        double avgSalary = employeeService.getAverageSalary();
        LOGGER.debug("Average Salary: {}", avgSalary);
        
        // Test getAverageSalary by department
        LOGGER.info("--- Testing getAverageSalary by department ---");
        double avgSalaryDept1 = employeeService.getAverageSalary(1);
        LOGGER.debug("Average Salary for Department 1: {}", avgSalaryDept1);
        
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
        
        // Test getEmployeesOrderedBySalary
        LOGGER.info("--- Testing getEmployeesOrderedBySalary ---");
        List<Employee> employeesBySalary = employeeService.getEmployeesOrderedBySalary();
        LOGGER.debug("Employees ordered by salary (desc): {}", employeesBySalary);
        
        // Test getEmployeesOrderedByName
        LOGGER.info("--- Testing getEmployeesOrderedByName ---");
        List<Employee> employeesByNameOrder = employeeService.getEmployeesOrderedByName();
        LOGGER.debug("Employees ordered by name: {}", employeesByNameOrder);
        
        LOGGER.info("=== HQL Queries Testing Complete ===");
    }
    
    private static void testNativeQueries() {
        LOGGER.info("=== Testing Native Queries ===");
        
        // Test getAllEmployeesNative
        LOGGER.info("--- Testing getAllEmployeesNative ---");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All Employees (Native): {}", employees);
        
        // Test getAllPermanentEmployeesNative
        LOGGER.info("--- Testing getAllPermanentEmployeesNative ---");
        List<Employee> permanentEmployees = employeeService.getAllPermanentEmployeesNative();
        LOGGER.debug("Permanent Employees (Native): {}", permanentEmployees);
        
        // Test getAverageSalaryNative
        LOGGER.info("--- Testing getAverageSalaryNative ---");
        double avgSalary = employeeService.getAverageSalaryNative();
        LOGGER.debug("Average Salary (Native): {}", avgSalary);
        
        // Test getAverageSalaryNative by department
        LOGGER.info("--- Testing getAverageSalaryNative by department ---");
        double avgSalaryDept1 = employeeService.getAverageSalaryNative(1);
        LOGGER.debug("Average Salary for Department 1 (Native): {}", avgSalaryDept1);
        
        // Test getEmployeesBySalaryRangeNative
        LOGGER.info("--- Testing getEmployeesBySalaryRangeNative ---");
        List<Employee> employeesInRange = employeeService.getEmployeesBySalaryRangeNative(70000.0, 90000.0);
        LOGGER.debug("Employees with salary between 70000-90000 (Native): {}", employeesInRange);
        
        // Test getEmployeesByNamePatternNative
        LOGGER.info("--- Testing getEmployeesByNamePatternNative ---");
        List<Employee> employeesByName = employeeService.getEmployeesByNamePatternNative("John");
        LOGGER.debug("Employees with name containing 'John' (Native): {}", employeesByName);
        
        // Test getEmployeesByDepartmentNative
        LOGGER.info("--- Testing getEmployeesByDepartmentNative ---");
        List<Employee> employeesByDept = employeeService.getEmployeesByDepartmentNative(1);
        LOGGER.debug("Employees in Department 1 (Native): {}", employeesByDept);
        
        // Test getEmployeesOrderedBySalaryNative
        LOGGER.info("--- Testing getEmployeesOrderedBySalaryNative ---");
        List<Employee> employeesBySalary = employeeService.getEmployeesOrderedBySalaryNative();
        LOGGER.debug("Employees ordered by salary (desc) (Native): {}", employeesBySalary);
        
        // Test getEmployeesOrderedByNameNative
        LOGGER.info("--- Testing getEmployeesOrderedByNameNative ---");
        List<Employee> employeesByNameOrder = employeeService.getEmployeesOrderedByNameNative();
        LOGGER.debug("Employees ordered by name (Native): {}", employeesByNameOrder);
        
        LOGGER.info("=== Native Queries Testing Complete ===");
    }
    
    private static void testAdvancedNativeQueries() {
        LOGGER.info("=== Testing Advanced Native Queries ===");
        
        // Test getEmployeesWithDepartmentInfo
        LOGGER.info("--- Testing getEmployeesWithDepartmentInfo ---");
        List<Object[]> employeesWithDept = employeeService.getEmployeesWithDepartmentInfo();
        LOGGER.debug("Employees with Department Info: {}", employeesWithDept);
        for (Object[] result : employeesWithDept) {
            LOGGER.debug("Employee ID: {}, Name: {}, Department: {}", result[0], result[1], result[6]);
        }
        
        // Test getDepartmentWiseEmployeeCount
        LOGGER.info("--- Testing getDepartmentWiseEmployeeCount ---");
        List<Object[]> deptEmployeeCount = employeeService.getDepartmentWiseEmployeeCount();
        LOGGER.debug("Department-wise Employee Count: {}", deptEmployeeCount);
        for (Object[] result : deptEmployeeCount) {
            LOGGER.debug("Department: {}, Employee Count: {}", result[0], result[1]);
        }
        
        // Test getDepartmentWiseAverageSalary
        LOGGER.info("--- Testing getDepartmentWiseAverageSalary ---");
        List<Object[]> deptAvgSalary = employeeService.getDepartmentWiseAverageSalary();
        LOGGER.debug("Department-wise Average Salary: {}", deptAvgSalary);
        for (Object[] result : deptAvgSalary) {
            LOGGER.debug("Department: {}, Average Salary: {}", result[0], result[1]);
        }
        
        LOGGER.info("=== Advanced Native Queries Testing Complete ===");
    }
} 