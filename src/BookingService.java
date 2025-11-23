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
    public void createBooking(Booking booking) throws TableAlreadyBookedException {
        if (!checkAvailability(booking.getTableId())) {
            throw new TableAlreadyBookedException("Ban nay da duoc dat hoac dang phuc vu!");
        }
        bookings.add(booking);

        // Cap nhat trang thai ban thanh BOOKED
        tableService.updateTableStatus(booking.getTableId(), TableStatus.BOOKED);
        System.out.println("Booking Success: " + booking.getBookingId());
    }

    public void cancelBooking(String tableId) {
        // Logic don gian: Reset trang thai ban ve AVAILABLE
        tableService.updateTableStatus(tableId, TableStatus.AVAILABLE);
        System.out.println("Da huy dat ban cho ban: " + tableId);
    }


    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }
}