public class ReportUI {
    private ReportService reportService; // Doi sang dung ReportService

    public ReportUI(InvoiceService invoiceService) {
        this.reportService = new ReportService(invoiceService);
    }

    public void handle() {
        System.out.println("\n--- BAO CAO ---");
        System.out.println("1. Doanh thu tong");
        System.out.println("2. Doanh thu theo ngay");
        int choice = InputHelper.getInt("Chon");

        if (choice == 1) {
            // Logic cu (ban tu them vao hoac giu nguyen)
        } else if (choice == 2) {
            String date = InputHelper.getString("Nhap ngay (yyyy-MM-dd)");
            double total = reportService.calculateDailyRevenue(date);
            System.out.println("Doanh thu ngay " + date + ": " + total + " VND");
        }
    }
}