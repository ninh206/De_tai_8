public class RestaurantApp {
    public static void main(String[] args) {
        System.out.println("Dang khoi dong he thong...");

        // 1. Khoi tao Services
        TableService tableService = new TableService();
        MenuService menuService = new MenuService();
        BookingService bookingService = new BookingService(tableService);
        InvoiceService invoiceService = new InvoiceService();

        // 2. Khoi tao UI
        TableUI tableUI = new TableUI(tableService);
        MenuUI menuUI = new MenuUI(menuService);
        BookingUI bookingUI = new BookingUI(bookingService);
        InvoiceUI invoiceUI = new InvoiceUI(invoiceService, tableService);
        ReportUI reportUI = new ReportUI(invoiceService, bookingService, menuService);

        // 3. Main Loop
        while (true) {
            System.out.println("\n=== HE THONG QUAN LY NHA HANG ===");
            System.out.println("1. Quan ly Ban an");
            System.out.println("2. Quan ly Thuc don");
            System.out.println("3. Dat ban (Booking)");
            System.out.println("4. Thanh toan & Hoa don");
            System.out.println("5. Bao cao & Thong ke");
            System.out.println("8. Chay Test Case");
            System.out.println("9. Reset du lieu mau");
            System.out.println("0. Thoat");

            int choice = InputHelper.getInt("Moi chon chuc nang");

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
                    // Reload services
                    tableService = new TableService();
                    menuService = new MenuService();
                    bookingService = new BookingService(tableService);
                    invoiceService = new InvoiceService();
                    // Reload UIs
                    tableUI = new TableUI(tableService);
                    menuUI = new MenuUI(menuService);
                    bookingUI = new BookingUI(bookingService);
                    invoiceUI = new InvoiceUI(invoiceService, tableService);
                    reportUI = new ReportUI(invoiceService, bookingService, menuService);
                    System.out.println("--> Da Reset du lieu!");
                    break;
                default: System.out.println("Sai chuc nang!");
            }
        }
    }
}