public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Just a mock for demo
        if (id.equals("C101")) {
            return "Amit (C101)";
        } else if (id.equals("C102")) {
            return "Priya (C102)";
        }
        return "Customer not found";
    }
} 