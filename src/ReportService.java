import java.util.ArrayList;
import java.util.Collections; // Đây là cái bạn cần để sort
import java.util.Comparator;
import java.util.List;

public class ReportService {
    private InvoiceService invoiceService;
    private BookingService bookingService;
    private MenuService menuService;

    // Constructor nhận đủ 3 service để lấy dữ liệu
    public ReportService(InvoiceService is, BookingService bs, MenuService ms) {
        this.invoiceService = is;
        this.bookingService = bs;
        this.menuService = ms;
    }

    // 1. Tính doanh thu theo ngày
    public double calculateDailyRevenue(String date) {
        double total = 0;
        List<Invoice> invoices = invoiceService.getAllInvoices();
        for (Invoice inv : invoices) {
            if (inv.getDate().equals(date)) {
                total += inv.getTotalAmount();
            }
        }
        return total;
    }

    // 2. Đếm số lượng đặt bàn theo ngày
    public int countBookingsByDate(String date) {
        int count = 0;
        List<Booking> bookings = bookingService.getBookings();
        for (Booking b : bookings) {
            if (b.getDate().equals(date)) {
                count++;
            }
        }
        return count;
    }

    // 3. Top 5 món bán chạy nhất
    public void printTop5BestSellers() {
        // Lấy tất cả món ăn
        List<MenuItem> items = new ArrayList<>(menuService.getAllItems());

        // Sắp xếp giảm dần theo salesCount
        // Sử dụng Collections.sort và Comparator
        Collections.sort(items, new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem o1, MenuItem o2) {
                // So sánh số lượng bán: Cao xếp trước (o2 - o1)
                return Integer.compare(o2.getSalesCount(), o1.getSalesCount());
            }
        });

        System.out.println("\n--- TOP 5 MON BAN CHAY ---");
        int limit = Math.min(items.size(), 5); // Chỉ lấy tối đa 5 món
        for (int i = 0; i < limit; i++) {
            MenuItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Da ban: " + item.getSalesCount());
        }
    }
}