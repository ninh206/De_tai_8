import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings;
    private TableService tableService; // Can TableService de check trang thai ban

    public BookingService(TableService tableService) {
        this.bookings = new ArrayList<>();
        this.tableService = tableService;
    }

    // Kiem tra ban co trong khong
    public boolean checkAvailability(String tableId) {
        try {
            Table t = tableService.getTableById(tableId);
            return t.getStatus() == TableStatus.AVAILABLE;
        } catch (TableNotFoundException e) {
            return false;
        }
    }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }
}