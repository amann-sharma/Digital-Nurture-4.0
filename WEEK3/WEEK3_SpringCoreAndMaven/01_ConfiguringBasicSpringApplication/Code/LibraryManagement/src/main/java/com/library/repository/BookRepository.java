package com.library.repository;

public class BookRepository {
    
    public BookRepository() {
        System.out.println("BookRepository: Constructor called");
    }
    
    public void saveBook(String bookName) {
        System.out.println("BookRepository: Saving book - " + bookName);
    }
    
    public String findBook(String bookName) {
        System.out.println("BookRepository: Finding book - " + bookName);
        return "Book found: " + bookName;
    }
    
    public void deleteBook(String bookName) {
        System.out.println("BookRepository: Deleting book - " + bookName);
    }
} 