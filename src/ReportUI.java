import java.util.List;

public class ReportUI {
    private InvoiceService invoiceService;

    public ReportUI(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void handle() {
        List<Invoice> list = invoiceService.getAllInvoices();
        double totalRevenue = 0;

        System.out.println("\n--- BAO CAO DOANH THU ---");
        System.out.printf("%-10s %-10s %-15s %-15s\n", "Ma HD", "Ban", "Ngay", "Tong Tien");

        for (Invoice inv : list) {
            System.out.printf("%-10s %-10s %-15s %-15.0f\n",
                    "HD...", "TB...", inv.getDate(), inv.getTotalAmount());
            // (Tam thoi in don gian vi Invoice chua co getter chi tiet id, tableId o cac buoc truoc)
            totalRevenue += inv.getTotalAmount();
        }

        System.out.println("---------------------------");
        System.out.println("TONG DOANH THU: " + totalRevenue + " VND");
    }
}