package com.cognizant.hqlnative.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.hqlnative.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // HQL Query: Get all employees
    @Query(value="SELECT e FROM Employee e")
    List<Employee> getAllEmployees();
    
    // HQL Query: Get all permanent employees
    @Query(value="SELECT e FROM Employee e WHERE e.permanent = 1")
    List<Employee> getAllPermanentEmployees();
    
    // HQL Query: Get average salary
    @Query(value="SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();
    
    // HQL Query: Get average salary by department
    @Query(value="SELECT AVG(e.salary) FROM Employee e WHERE e.departmentId = :id")
    double getAverageSalary(@Param("id") int id);
    
    // HQL Query: Get employees by salary range
    @Query(value="SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> getEmployeesBySalaryRange(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary);
    
    // HQL Query: Get employees by name pattern
    @Query(value="SELECT e FROM Employee e WHERE e.name LIKE %:namePattern%")
    List<Employee> getEmployeesByNamePattern(@Param("namePattern") String namePattern);
    
    // HQL Query: Get employees by department
    @Query(value="SELECT e FROM Employee e WHERE e.departmentId = :departmentId")
    List<Employee> getEmployeesByDepartment(@Param("departmentId") int departmentId);
    
    // HQL Query: Get employees ordered by salary descending
    @Query(value="SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeesOrderedBySalary();
    
    // HQL Query: Get employees ordered by name
    @Query(value="SELECT e FROM Employee e ORDER BY e.name")
    List<Employee> getEmployeesOrderedByName();
    
    // Native Query: Get all employees
    @Query(value="SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
    
    // Native Query: Get all permanent employees
    @Query(value="SELECT * FROM employee WHERE em_permanent = 1", nativeQuery = true)
    List<Employee> getAllPermanentEmployeesNative();
    
    // Native Query: Get average salary
    @Query(value="SELECT AVG(em_salary) FROM employee", nativeQuery = true)
    double getAverageSalaryNative();
    
    // Native Query: Get average salary by department
    @Query(value="SELECT AVG(em_salary) FROM employee WHERE em_dp_id = :id", nativeQuery = true)
    double getAverageSalaryNative(@Param("id") int id);
    
    // Native Query: Get employees by salary range
    @Query(value="SELECT * FROM employee WHERE em_salary BETWEEN :minSalary AND :maxSalary", nativeQuery = true)
    List<Employee> getEmployeesBySalaryRangeNative(@Param("minSalary") double minSalary, @Param("maxSalary") double maxSalary);
    
    // Native Query: Get employees by name pattern
    @Query(value="SELECT * FROM employee WHERE em_name LIKE %:namePattern%", nativeQuery = true)
    List<Employee> getEmployeesByNamePatternNative(@Param("namePattern") String namePattern);
    
    // Native Query: Get employees by department
    @Query(value="SELECT * FROM employee WHERE em_dp_id = :departmentId", nativeQuery = true)
    List<Employee> getEmployeesByDepartmentNative(@Param("departmentId") int departmentId);
    
    // Native Query: Get employees ordered by salary descending
    @Query(value="SELECT * FROM employee ORDER BY em_salary DESC", nativeQuery = true)
    List<Employee> getEmployeesOrderedBySalaryNative();
    
    // Native Query: Get employees ordered by name
    @Query(value="SELECT * FROM employee ORDER BY em_name", nativeQuery = true)
    List<Employee> getEmployeesOrderedByNameNative();
    
    // Native Query: Get employees with department info using JOIN
    @Query(value="SELECT e.*, d.dp_name FROM employee e JOIN department d ON e.em_dp_id = d.dp_id", nativeQuery = true)
    List<Object[]> getEmployeesWithDepartmentInfo();
    
    // Native Query: Get department-wise employee count
    @Query(value="SELECT d.dp_name, COUNT(e.em_id) FROM department d LEFT JOIN employee e ON d.dp_id = e.em_dp_id GROUP BY d.dp_id, d.dp_name", nativeQuery = true)
    List<Object[]> getDepartmentWiseEmployeeCount();
    
    // Native Query: Get department-wise average salary
    @Query(value="SELECT d.dp_name, AVG(e.em_salary) FROM department d LEFT JOIN employee e ON d.dp_id = e.em_dp_id GROUP BY d.dp_id, d.dp_name", nativeQuery = true)
    List<Object[]> getDepartmentWiseAverageSalary();
} 