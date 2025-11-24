import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    private List<Invoice> invoices;
    private DiscountPolicy discountPolicy;

    public InvoiceService() {
        this.invoices = new ArrayList<>();
        this.discountPolicy = new VipDiscount(); // Mac dinh dung VIP Discount
    }

    public Invoice createInvoice(String id, String tableId, double rawTotal, String date) {
        double discount = discountPolicy.getDiscountAmount(rawTotal);
        double finalTotal = rawTotal - discount;

        Invoice invoice = new Invoice(id, tableId, finalTotal, date);
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> getAllInvoices() { return invoices; }
    public void setInvoices(List<Invoice> invoices) { this.invoices = invoices; }
}