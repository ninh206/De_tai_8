import java.util.List;

public class CustomerService {
    private List<Customer> customers;
    private CustomerRepository customerRepo;

    public CustomerService() {
        this.customerRepo = new CustomerRepository();
        this.customers = customerRepo.load();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customerRepo.save(customers);
    }

    public Customer findByPhone(String phone) throws CustomerNotFoundException {
        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) return c;
        }
        throw new CustomerNotFoundException("Khong tim thay khach hang co SDT: " + phone);
    }
}