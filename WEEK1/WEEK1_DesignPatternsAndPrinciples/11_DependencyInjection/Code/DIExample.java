public class DIExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.printCustomer("C101");
        service.printCustomer("C102");
        service.printCustomer("C999");
    }
} 