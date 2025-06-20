import java.util.*;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);
        // Adding sample employees
        manager.addEmployee(new Employee(1, "Amit", "Developer", 70000));
        manager.addEmployee(new Employee(2, "Priya", "Manager", 85000));
        manager.addEmployee(new Employee(3, "Rahul", "Analyst", 60000));
        manager.addEmployee(new Employee(4, "Sneha", "Designer", 65000));
        System.out.println("All employees:");
        manager.traverseEmployees();
        System.out.println("\nSearching for employee with ID 3:");
        Employee employee = manager.searchEmployeeById(3);
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("\nDeleting employee with ID 2:");
        boolean isDeleted = manager.deleteEmployeeById(2);
        System.out.println("Deleted: " + isDeleted);
        // Traversing and printing employees after deletion
        System.out.println("\nAll employees after deletion:");
        manager.traverseEmployees();
    }
} 