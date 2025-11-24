public class ReportUI {
    private ReportService reportService; // Doi sang dung ReportService

    public ReportUI(InvoiceService is, BookingService bs) {
        this.reportService = new ReportService(is, bs);
    }

    public void handle() {
        System.out.println("\n--- BAO CAO ---");
        System.out.println("1. Doanh thu tong");
        System.out.println("2. Doanh thu theo ngay");
        System.out.println("3. Thong ke so luong dat ban");
        int choice = InputHelper.getInt("Chon");

        if (choice == 1) {
            // Logic cu (ban tu them vao hoac giu nguyen)
        } else if (choice == 2) {
            String date = InputHelper.getString("Nhap ngay (yyyy-MM-dd)");
            double total = reportService.calculateDailyRevenue(date);
            System.out.println("Doanh thu ngay " + date + ": " + total + " VND");
        }
        if (choice == 3) {
            String date = InputHelper.getString("Nhap ngay (yyyy-MM-dd)");
            int count = reportService.countBookingsByDate(date);
            System.out.println("So luong dat ban ngay " + date + ": " + count);
        }
    }
}