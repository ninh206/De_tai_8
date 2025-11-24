// Can them BookingService vao ReportService
public class ReportService {
    private InvoiceService invoiceService;
    private BookingService bookingService; // Them

    public ReportService(InvoiceService is, BookingService bs) {
        this.invoiceService = is;
        this.bookingService = bs;
    }

    // ... (Giữ hàm cũ)

    public int countBookingsByDate(String date) {
        int count = 0;
        for (Booking b : bookingService.getBookings()) {
            if (b.getDate().equals(date)) {
                count++;
            }
        }
        return count;
    }
}