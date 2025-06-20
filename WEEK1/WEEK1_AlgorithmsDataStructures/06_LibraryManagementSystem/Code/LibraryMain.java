import java.util.*;

public class LibraryMain {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager(10);
        manager.addBook(new Book(1, "Java Basics", "Rahul"));
        manager.addBook(new Book(2, "Data Structures", "Priya"));
        manager.addBook(new Book(3, "Algorithms", "Amit"));
        manager.addBook(new Book(4, "Spring Boot", "Sneha"));
        System.out.println("All books:");
        manager.traverseBooks();
        System.out.println("\nLinear Search for 'Algorithms':");
        Book found = manager.linearSearchByTitle("Algorithms");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Book not found.");
        }
        manager.sortBooksByTitle();
        System.out.println("\nBinary Search for 'Spring Boot':");
        found = manager.binarySearchByTitle("Spring Boot");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Book not found.");
        }
    }
} 