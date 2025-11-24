import java.util.List;

public class ReportService {
    private InvoiceService invoiceService;

    public ReportService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

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
}