public class CustomerService {
    private CustomerRepository repository;
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void printCustomer(String id) {
        String customer = repository.findCustomerById(id);
        System.out.println("Customer: " + customer);
    }
} 