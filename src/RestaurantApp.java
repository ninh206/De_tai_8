public class RestaurantApp {
    public static void main(String[] args) {
        // 1. Khoi tao Data mau (Chay 1 lan roi comment lai neu muon)
        // DataSeeder.generateData();

        // 2. Khoi tao Services
        TableService tableService = new TableService();
        MenuService menuService = new MenuService();
        // BookingService & InvoiceService se them sau

        // 3. Khoi tao UI
        TableUI tableUI = new TableUI(tableService);
        MenuUI menuUI = new MenuUI(menuService);

        // 4. Main Loop
        while (true) {
            System.out.println("\n=== HE THONG QUAN LY NHA HANG ===");
            System.out.println("1. Quan ly Ban an");
            System.out.println("2. Quan ly Thuc don");
            System.out.println("3. Dat ban (Coming soon)");
            System.out.println("4. Thanh toan (Coming soon)");
            System.out.println("9. Khoi tao du lieu mau (Reset)");
            System.out.println("0. Thoat");

            int choice = InputHelper.getInt("Chon chuc nang");
            if (choice == 0) {
                System.out.println("Tam biet!");
                break;
            }

            switch (choice) {
                case 1: tableUI.handle(); break;
                case 2: menuUI.handle(); break;
                case 9:
                    DataSeeder.generateData();
                    // Reload lai data cho service
                    tableService = new TableService();
                    menuService = new MenuService();
                    tableUI = new TableUI(tableService);
                    menuUI = new MenuUI(menuService);
                    break;
                default: System.out.println("Chuc nang dang phat trien!");
            }
        }
    }
}