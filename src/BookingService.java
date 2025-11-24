import java.util.List;

public class BookingService {
    private List<Booking> bookings;
    private TableService tableService;
    private BookingRepository bookingRepo; // Them Repo

    public BookingService(TableService tableService) {
        this.tableService = tableService;
        this.bookingRepo = new BookingRepository();
        this.bookings = bookingRepo.load(); // Load du lieu cu tu file
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
            throw new TableAlreadyBookedException("Ban khong hop le!");
        }
        bookings.add(booking);
        bookingRepo.save(bookings); // Luu xuong file

        tableService.updateTableStatus(booking.getTableId(), TableStatus.BOOKED);
    }

    public void cancelBooking(String tableId) {
        // Xoa booking theo tableId (Logic don gian)
        bookings.removeIf(b -> b.getTableId().equals(tableId));
        bookingRepo.save(bookings); // Cap nhat file

        tableService.updateTableStatus(tableId, TableStatus.AVAILABLE);
        System.out.println("Da huy dat ban.");
    }

    public List<Booking> getBookings() { return bookings; }
}