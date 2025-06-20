import java.util.*;

public class SortingMain {
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Amit", 2500.50),
            new Order("O002", "Priya", 1500.75),
            new Order("O003", "Rahul", 3200.10),
            new Order("O004", "Sneha", 1800.20),
            new Order("O005", "Vikas", 2100.80)
        };
        System.out.println("Before Bubble Sort:");
        printOrders(orders);
        SortingAlgorithms.bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        printOrders(orders);
        orders = new Order[]{
            new Order("O001", "Amit", 2500.50),
            new Order("O002", "Priya", 1500.75),
            new Order("O003", "Rahul", 3200.10),
            new Order("O004", "Sneha", 1800.20),
            new Order("O005", "Vikas", 2100.80)
        };
        System.out.println("\nBefore Quick Sort:");
        printOrders(orders);
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        printOrders(orders);
    }
} 