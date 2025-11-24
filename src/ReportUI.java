public class ReportUI {
    private ReportService reportService;

    // Cập nhật Constructor nhận đủ 3 service
    public ReportUI(InvoiceService is, BookingService bs, MenuService ms) {
        this.reportService = new ReportService(is, bs, ms);
    }

    public void handle() {
        while (true) {
            System.out.println("\n--- BAO CAO & THONG KE ---");
            System.out.println("1. Doanh thu theo ngay");
            System.out.println("2. So luong dat ban theo ngay");
            System.out.println("3. Top 5 mon ban chay");
            System.out.println("0. Quay lai");

            int choice = InputHelper.getInt("Chon");
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    String date1 = InputHelper.getString("Nhap ngay (yyyy-MM-dd)");
                    double total = reportService.calculateDailyRevenue(date1);
                    System.out.println("=> Doanh thu: " + total + " VND");
                    break;
                case 2:
                    String date2 = InputHelper.getString("Nhap ngay (yyyy-MM-dd)");
                    int count = reportService.countBookingsByDate(date2);
                    System.out.println("=> So luong dat ban: " + count);
                    break;
                case 3:
                    reportService.printTop5BestSellers();
                    break;
                default:
                    System.out.println("Chon sai!");
            }
        }
    }
}