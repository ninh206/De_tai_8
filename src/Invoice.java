import java.io.Serializable;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id, tableId, date;
    private double totalAmount;

    public Invoice(String id, String tableId, double totalAmount, String date) {
        this.id = id;
        this.tableId = tableId;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    public double getTotalAmount() { return totalAmount; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return "HD " + id + ": " + totalAmount + " VND (" + date + ")";
    }
}