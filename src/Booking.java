import java.io.Serializable;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    private String bookingId, customerId, tableId, date, time;

    public Booking(String bookingId, String customerId, String tableId, String date, String time) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.tableId = tableId;
        this.date = date;
        this.time = time;
    }
    public String getTableId() { return tableId; }
    public String getDate() { return date; }
    public String getBookingId() { return bookingId; }

    @Override
    public String toString() {
        return "Booking " + bookingId + ": Ban " + tableId + " - " + date + " " + time;
    }
}