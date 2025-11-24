import java.time.LocalDate;
import java.util.UUID;

public class InvoiceUI {
    private InvoiceService invoiceService;
    private TableService tableService;

    public InvoiceUI(InvoiceService invoiceService, TableService tableService) {
        this.invoiceService = invoiceService;
        this.tableService = tableService;
    }

    public void handle() {
        System.out.println("\n--- THANH TOAN ---");
        String tableId = InputHelper.getString("Nhap ID ban can thanh toan");

        try {
            Table t = tableService.getTableById(tableId);
            if (t.getStatus() == TableStatus.AVAILABLE) {
                System.out.println("Ban nay dang trong, khong the thanh toan!");
                return;
            }

            double amount = InputHelper.getDouble("Nhap tong tien mon an (Tam thoi nhap tay)");
            // Sau nay se tu tinh dua tren OrderService neu co

            String invoiceId = UUID.randomUUID().toString().substring(0, 8);
            String date = LocalDate.now().toString();

            Invoice inv = invoiceService.createInvoice(invoiceId, tableId, amount, date);

            // Reset ban ve trang thai trong
            tableService.updateTableStatus(tableId, TableStatus.AVAILABLE);

            System.out.println("\n--- HOA DON ---");
            System.out.println(inv);
            System.out.println("Da xuat hoa don va reset ban!");

        } catch (TableNotFoundException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
}