package com.cognizant.ormlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

public class OrmLearnApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        
        LOGGER.info("Inside main");
        
        // Test O/R Mapping relationships
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();
        
        // Test HQL and Native Queries
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAverageSalaryByDepartment();
        testGetAllEmployeesNative();
    }
    
    private static void testGetEmployee() {
        LOGGER.info("=== Testing GetEmployee ===");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }
    
    private static void testAddEmployee() {
        LOGGER.info("=== Testing AddEmployee ===");
        try {
            Employee newEmployee = new Employee("John Doe", 50000.0, true, new Date());
            Department department = departmentService.get(1);
            newEmployee.setDepartment(department);
            employeeService.save(newEmployee);
            LOGGER.debug("Added employee: {}", newEmployee);
        } catch (Exception e) {
            LOGGER.error("Error adding employee: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
    
    private static void testUpdateEmployee() {
        LOGGER.info("=== Testing UpdateEmployee ===");
        try {
            Employee employee = employeeService.get(1);
            Department newDepartment = departmentService.get(2);
            employee.setDepartment(newDepartment);
            employeeService.save(employee);
            LOGGER.debug("Updated employee: {}", employee);
        } catch (Exception e) {
            LOGGER.error("Error updating employee: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
    
    private static void testGetDepartment() {
        LOGGER.info("=== Testing GetDepartment ===");
        try {
            Department department = departmentService.get(1);
            LOGGER.debug("Department:{}", department);
            LOGGER.debug("EmployeeList:{}", department.getEmployeeList());
        } catch (Exception e) {
            LOGGER.error("Error getting department: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
    
    private static void testAddSkillToEmployee() {
        LOGGER.info("=== Testing AddSkillToEmployee ===");
        try {
            Employee employee = employeeService.get(1);
            Skill skill = skillService.get(1);
            employee.getSkillList().add(skill);
            employeeService.save(employee);
            LOGGER.debug("Added skill to employee: {}", employee);
        } catch (Exception e) {
            LOGGER.error("Error adding skill to employee: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
    
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("=== Testing GetAllPermanentEmployees ===");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }
    
    private static void testGetAverageSalary() {
        LOGGER.info("=== Testing GetAverageSalary ===");
        double avgSalary = employeeService.getAverageSalary();
        LOGGER.debug("Average Salary: {}", avgSalary);
        LOGGER.info("End");
    }
    
    private static void testGetAverageSalaryByDepartment() {
        LOGGER.info("=== Testing GetAverageSalaryByDepartment ===");
        double avgSalary = employeeService.getAverageSalary(1);
        LOGGER.debug("Average Salary for Department 1: {}", avgSalary);
        LOGGER.info("End");
    }
    
    private static void testGetAllEmployeesNative() {
        LOGGER.info("=== Testing GetAllEmployeesNative ===");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All Employees (Native Query): {}", employees);
        LOGGER.info("End");
    }
} 