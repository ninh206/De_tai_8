import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Persistable<Customer> {
    private static final String FILE_NAME = "customers.csv";

    @Override
    public void save(List<Customer> customers) {
        List<String> lines = new ArrayList<>();
        for (Customer c : customers) {
            lines.add(c.getId() + "," + c.getName() + "," + c.getPhone());
        }
        CsvHelper.write(FILE_NAME, lines);
    }

    @Override
    public List<Customer> load() {
        List<Customer> customers = new ArrayList<>();
        List<String> lines = CsvHelper.read(FILE_NAME);

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 3) {
                customers.add(new Customer(parts[0], parts[1], parts[2]));
            }
        }
        return customers;
    }
}