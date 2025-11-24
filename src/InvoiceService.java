import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
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
    public void exportInvoiceToText(Invoice invoice) {
        String filename = "Invoice_" + invoice.getDate() + ".txt";
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("----- HOA DON -----\n");
            writer.write(invoice.toString() + "\n");
            writer.write("-------------------\n\n");
            System.out.println("Da xuat hoa don ra file: " + filename);
        } catch (IOException e) {
            System.out.println("Loi xuat file: " + e.getMessage());
        }
    }

    public List<Invoice> getAllInvoices() { return invoices; }
}