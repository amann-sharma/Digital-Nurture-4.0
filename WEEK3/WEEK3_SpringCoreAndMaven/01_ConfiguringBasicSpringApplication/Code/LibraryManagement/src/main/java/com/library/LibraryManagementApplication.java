package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    
    public static void main(String[] args) {
        System.out.println("=== Exercise 1: Configuring a Basic Spring Application ===");
        
        // Load the Spring application context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Spring context loaded successfully!");
        
        // Get the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");
        
        // Test the configuration
        System.out.println("\n--- Testing Book Operations ---");
        bookService.addBook("Java Programming");
        String result = bookService.getBook("Java Programming");
        System.out.println("Result: " + result);
        bookService.removeBook("Java Programming");
        
        System.out.println("\n=== Exercise 1 completed successfully! ===");
    }
} 