import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id, name;
    protected double price;
    protected MenuItemType type;
    protected int salesCount = 0; // Them thuoc tinh nay
    public void incrementSales() { this.salesCount++; }
    public int getSalesCount() { return salesCount; }
    public MenuItem(String id, String name, double price, MenuItemType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public MenuItemType getType() { return type; }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " : " + price;
    }
}