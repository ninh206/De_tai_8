public class Customer extends Person {
    public Customer(String id, String name, String phone) {
        super(id, name, phone);
    }
    @Override
    public String toString() { return id + " | " + name + " | " + phone; }
}