import java.util.List;

public class InvoiceService {
    private List<Invoice> invoices;
    private DiscountPolicy discountPolicy;
    private InvoiceRepository invoiceRepo; // Them Repo

    public InvoiceService() {
        this.discountPolicy = new VipDiscount();
        this.invoiceRepo = new InvoiceRepository();
        this.invoices = invoiceRepo.load(); // Load tu file
    }

    public Invoice createInvoice(String id, String tableId, double rawTotal, String date) {
        double discount = discountPolicy.getDiscountAmount(rawTotal);
        double finalTotal = rawTotal - discount;

        Invoice invoice = new Invoice(id, tableId, finalTotal, date);
        invoices.add(invoice);

        invoiceRepo.save(invoices); // Luu xuong file ngay lap tuc
        return invoice;
    }

    public List<Invoice> getAllInvoices() { return invoices; }
}