public class RestaurantApp {
    public static void main(String[] args) {
        // Khoi tao Services
        TableService tableService = new TableService();
        MenuService menuService = new MenuService();
        BookingService bookingService = new BookingService(tableService);
        InvoiceService invoiceService = new InvoiceService();

        // Khoi tao UI
        TableUI tableUI = new TableUI(tableService);
        MenuUI menuUI = new MenuUI(menuService);
        BookingUI bookingUI = new BookingUI(bookingService);
        InvoiceUI invoiceUI = new InvoiceUI(invoiceService, tableService);
        ReportUI reportUI = new ReportUI(invoiceService);

        while (true) {
            System.out.println("\n=== HE THONG QUAN LY NHA HANG ===");
            System.out.println("1. Quan ly Ban an");
            System.out.println("2. Quan ly Thuc don");
            System.out.println("3. Dat ban & Check-in");
            System.out.println("4. Thanh toan");
            System.out.println("5. Bao cao doanh thu");
            System.out.println("8. Chay kiem thu (Test Cases)");
            System.out.println("9. Reset data mau");
            System.out.println("0. Thoat");

            int choice = InputHelper.getInt("Chon");
            if (choice == 0) break;

            switch (choice) {
                case 1: tableUI.handle(); break;
                case 2: menuUI.handle(); break;
                case 3: bookingUI.handle(); break;
                case 4: invoiceUI.handle(); break;
                case 5: reportUI.handle(); break;
                case 8: TestRunner.runAllTests(); break;
                case 9:
                    DataSeeder.generateData();
                    System.out.println("Vui long khoi dong lai app de load data moi!");
                    return;
                default: System.out.println("Sai chuc nang!");
            }
        }
    }
}