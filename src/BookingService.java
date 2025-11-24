import java.util.List;
import java.time.LocalDate;

public class BookingService {
    private List<Booking> bookings;
    private TableService tableService;
    private BookingRepository bookingRepo;

    public BookingService(TableService tableService) {
        this.tableService = tableService;
        this.bookingRepo = new BookingRepository();
        this.bookings = bookingRepo.load();
    }

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
            throw new TableAlreadyBookedException("Ban da duoc dat hoac dang phuc vu!");
        }

        // --- VALIDATE NGAY QUA KHU ---
        try {
            LocalDate bookingDate = LocalDate.parse(booking.getDate());
            if (bookingDate.isBefore(LocalDate.now())) {
                throw new RuntimeException("Khong the dat ban cho ngay trong qua khu!");
            }
        } catch (Exception e) {
            System.out.println("Canh bao ngay thang: " + e.getMessage());
        }
        // -----------------------------

        bookings.add(booking);
        bookingRepo.save(bookings);
        tableService.updateTableStatus(booking.getTableId(), TableStatus.BOOKED);
    }

    public void cancelBooking(String tableId) {
        bookings.removeIf(b -> b.getTableId().equals(tableId));
        bookingRepo.save(bookings);
        tableService.updateTableStatus(tableId, TableStatus.AVAILABLE);
        System.out.println("Da huy dat ban.");
    }

    public Booking findBookingByCustomerPhone(String keyword) {
        for (Booking b : bookings) {
            if (b.toString().contains(keyword)) return b;
        }
        return null;
    }

    public List<Booking> getBookings() { return bookings; }
}