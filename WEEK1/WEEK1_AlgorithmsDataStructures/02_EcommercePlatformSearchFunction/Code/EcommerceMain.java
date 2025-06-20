import java.util.*;

public class EcommerceMain {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P004", "Monitor", "Electronics"),
            new Product("P005", "Keyboard", "Accessories")
        };
        System.out.println("Linear Search:");
        String searchName = "Tablet";
        Product foundProduct = SearchAlgorithms.linearSearch(products, searchName);
        if (foundProduct != null) {
            System.out.println("Found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("\nBinary Search:");
        searchName = "Monitor";
        foundProduct = SearchAlgorithms.binarySearch(products, searchName);
        if (foundProduct != null) {
            System.out.println("Found: " + foundProduct);
        } else {
            System.out.println("Product not found.");
        }
    }
} 