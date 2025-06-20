public class InventoryMain {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Product product1 = new Product("P001", "Product_no_1", 50, 999.99);
        Product product2 = new Product("P002", "Product_no_2", 30, 899.99);
        Product product3 = new Product("P003", "Product_no_3", 100, 349.99);
        Product product4 = new Product("P004", "Product_no_4", 25, 1249.99);
        Product product5 = new Product("P005", "Product_no_5", 15, 2399.99);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        System.out.println("All products after adding:");
        manager.displayProducts();
        Product updatedProduct1 = new Product("P001", "Product_no_1", 60, 949.99);
        manager.updateProduct(updatedProduct1);
        System.out.println("\nAll products after updating Product_no_1:");
        manager.displayProducts();
        manager.deleteProduct("P002");
        System.out.println("\nAll products after deleting Product_no_2:");
        manager.displayProducts();
    }
} 