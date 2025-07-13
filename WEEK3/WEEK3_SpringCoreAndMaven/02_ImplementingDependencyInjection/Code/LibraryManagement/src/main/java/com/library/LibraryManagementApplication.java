package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        System.out.println("=== Exercise 2: Implementing Dependency Injection ===");
        
        // Load the Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Spring context loaded successfully!");
        System.out.println("Dependency injection configured via XML configuration");
        
        // Get the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");
        
        // Test the dependency injection
        System.out.println("\n--- Testing Dependency Injection ---");
        System.out.println("BookService has BookRepository injected via setter method");
        bookService.addBook("Spring Framework");
        String result = bookService.getBook("Spring Framework");
        System.out.println("Result: " + result);
        bookService.removeBook("Spring Framework");
        
        System.out.println("\n=== Exercise 2 completed successfully! ===");
        System.out.println("Dependency injection working correctly - BookService has access to BookRepository");
    }
} 