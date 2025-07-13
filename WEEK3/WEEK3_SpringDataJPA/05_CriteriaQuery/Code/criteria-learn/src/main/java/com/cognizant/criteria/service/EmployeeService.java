package com.cognizant.criteria.service;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.criteria.model.Employee;
import com.cognizant.criteria.repository.EmployeeRepository;

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

    // Criteria Query: Get all employees
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Criteria Query: Get all permanent employees
    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("permanent"), true);
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees by salary range
    @Transactional
    public List<Employee> getEmployeesBySalaryRange(double minSalary, double maxSalary) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.between(root.get("salary"), minSalary, maxSalary);
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees by name pattern
    @Transactional
    public List<Employee> getEmployeesByNamePattern(String namePattern) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.like(root.get("name"), "%" + namePattern + "%");
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees by department
    @Transactional
    public List<Employee> getEmployeesByDepartment(int departmentId) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("departmentId"), departmentId);
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with salary greater than
    @Transactional
    public List<Employee> getEmployeesWithSalaryGreaterThan(double salary) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.greaterThan(root.get("salary"), salary);
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with salary less than
    @Transactional
    public List<Employee> getEmployeesWithSalaryLessThan(double salary) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.lessThan(root.get("salary"), salary);
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees by date of birth range
    @Transactional
    public List<Employee> getEmployeesByDateOfBirthRange(Date startDate, Date endDate) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.between(root.get("dateOfBirth"), startDate, endDate);
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with complex conditions
    @Transactional
    public List<Employee> getEmployeesWithComplexConditions(double minSalary, double maxSalary, boolean permanent, int departmentId) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> {
            Predicate salaryPredicate = criteriaBuilder.between(root.get("salary"), minSalary, maxSalary);
            Predicate permanentPredicate = criteriaBuilder.equal(root.get("permanent"), permanent);
            Predicate departmentPredicate = criteriaBuilder.equal(root.get("departmentId"), departmentId);
            
            return criteriaBuilder.and(salaryPredicate, permanentPredicate, departmentPredicate);
        };
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees ordered by salary descending
    @Transactional
    public List<Employee> getEmployeesOrderedBySalary() {
        return employeeRepository.findAll((root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("salary")));
            return null;
        });
    }

    // Criteria Query: Get employees ordered by name
    @Transactional
    public List<Employee> getEmployeesOrderedByName() {
        return employeeRepository.findAll((root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("name")));
            return null;
        });
    }

    // Criteria Query: Get employees with OR conditions
    @Transactional
    public List<Employee> getEmployeesWithOrConditions(double salary1, double salary2, int departmentId1, int departmentId2) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> {
            Predicate salaryOrPredicate = criteriaBuilder.or(
                criteriaBuilder.equal(root.get("salary"), salary1),
                criteriaBuilder.equal(root.get("salary"), salary2)
            );
            Predicate departmentOrPredicate = criteriaBuilder.or(
                criteriaBuilder.equal(root.get("departmentId"), departmentId1),
                criteriaBuilder.equal(root.get("departmentId"), departmentId2)
            );
            
            return criteriaBuilder.and(salaryOrPredicate, departmentOrPredicate);
        };
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with NOT conditions
    @Transactional
    public List<Employee> getEmployeesWithNotConditions(double salary, int departmentId) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> {
            Predicate notSalaryPredicate = criteriaBuilder.notEqual(root.get("salary"), salary);
            Predicate notDepartmentPredicate = criteriaBuilder.notEqual(root.get("departmentId"), departmentId);
            
            return criteriaBuilder.and(notSalaryPredicate, notDepartmentPredicate);
        };
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with IN conditions
    @Transactional
    public List<Employee> getEmployeesWithInConditions(List<Double> salaries, List<Integer> departmentIds) {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> {
            Predicate salaryInPredicate = root.get("salary").in(salaries);
            Predicate departmentInPredicate = root.get("departmentId").in(departmentIds);
            
            return criteriaBuilder.and(salaryInPredicate, departmentInPredicate);
        };
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with NULL conditions
    @Transactional
    public List<Employee> getEmployeesWithNullConditions() {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.isNull(root.get("dateOfBirth"));
        return employeeRepository.findAll(spec);
    }

    // Criteria Query: Get employees with NOT NULL conditions
    @Transactional
    public List<Employee> getEmployeesWithNotNullConditions() {
        Specification<Employee> spec = (root, query, criteriaBuilder) -> 
            criteriaBuilder.isNotNull(root.get("dateOfBirth"));
        return employeeRepository.findAll(spec);
    }
} 