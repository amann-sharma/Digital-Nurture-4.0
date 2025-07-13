package com.cognizant.hqlnative.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.hqlnative.model.Employee;
import com.cognizant.hqlnative.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee get(int id) {
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    // HQL Query Methods
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public double getAverageSalary() {
        return employeeRepository.getAverageSalary();
    }

    @Transactional
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);
    }

    @Transactional
    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
        return employeeRepository.getEmployeesBySalaryRange(minSalary, maxSalary);
    }

    @Transactional
    public List<Employee> getEmployeesByNamePattern(String namePattern) {
        return employeeRepository.getEmployeesByNamePattern(namePattern);
    }

    @Transactional
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        return employeeRepository.getEmployeesByDepartment(departmentId);
    }

    @Transactional
    public List<Employee> getEmployeesOrderedBySalary() {
        return employeeRepository.getEmployeesOrderedBySalary();
    }

    @Transactional
    public List<Employee> getEmployeesOrderedByName() {
        return employeeRepository.getEmployeesOrderedByName();
    }

    // Native Query Methods
    @Transactional
    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }

    @Transactional
    public List<Employee> getAllPermanentEmployeesNative() {
        return employeeRepository.getAllPermanentEmployeesNative();
    }

    @Transactional
    public double getAverageSalaryNative() {
        return employeeRepository.getAverageSalaryNative();
    }

    @Transactional
    public double getAverageSalaryNative(int departmentId) {
        return employeeRepository.getAverageSalaryNative(departmentId);
    }

    @Transactional
    public List<Employee> getEmployeesBySalaryRangeNative(double minSalary, double maxSalary) {
        return employeeRepository.getEmployeesBySalaryRangeNative(minSalary, maxSalary);
    }

    @Transactional
    public List<Employee> getEmployeesByNamePatternNative(String namePattern) {
        return employeeRepository.getEmployeesByNamePatternNative(namePattern);
    }

    @Transactional
    public List<Employee> getEmployeesByDepartmentNative(int departmentId) {
        return employeeRepository.getEmployeesByDepartmentNative(departmentId);
    }

    @Transactional
    public List<Employee> getEmployeesOrderedBySalaryNative() {
        return employeeRepository.getEmployeesOrderedBySalaryNative();
    }

    @Transactional
    public List<Employee> getEmployeesOrderedByNameNative() {
        return employeeRepository.getEmployeesOrderedByNameNative();
    }

    @Transactional
    public List<Object[]> getEmployeesWithDepartmentInfo() {
        return employeeRepository.getEmployeesWithDepartmentInfo();
    }

    @Transactional
    public List<Object[]> getDepartmentWiseEmployeeCount() {
        return employeeRepository.getDepartmentWiseEmployeeCount();
    }

    @Transactional
    public List<Object[]> getDepartmentWiseAverageSalary() {
        return employeeRepository.getDepartmentWiseAverageSalary();
    }
} 