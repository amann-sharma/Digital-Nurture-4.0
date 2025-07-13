package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService: Constructor called");
    }
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter");
    }
    
    public void addBook(String bookName) {
        System.out.println("BookService: Adding book - " + bookName);
        if (bookRepository != null) {
            bookRepository.saveBook(bookName);
        } else {
            System.out.println("BookService: BookRepository is null!");
        }
    }
    
    public String getBook(String bookName) {
        System.out.println("BookService: Getting book - " + bookName);
        if (bookRepository != null) {
            return bookRepository.findBook(bookName);
        } else {
            System.out.println("BookService: BookRepository is null!");
            return "Book not found - repository not available";
        }
    }
    
    public void removeBook(String bookName) {
        System.out.println("BookService: Removing book - " + bookName);
        if (bookRepository != null) {
            bookRepository.deleteBook(bookName);
        } else {
            System.out.println("BookService: BookRepository is null!");
        }
    }
} 