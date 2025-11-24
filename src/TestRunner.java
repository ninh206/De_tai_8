public class TestRunner {
    public static void runAllTests() {
        System.out.println("=== BAT DAU CHAY TEST CASE ===");
        testBookingSuccess();
        testBookingFail();
        testCalculateInvoice();
        System.out.println("=== KET THUC TEST CASE ===");
    }

    // Cac ham test se them sau
    private static void testBookingSuccess() { System.out.println("Test 1: Pending..."); }
    private static void testBookingFail() { System.out.println("Test 2: Pending..."); }
    private static void testCalculateInvoice() { System.out.println("Test 3: Pending..."); }
    private static void testBookingSuccess() {
        System.out.print("Test 1 (Dat ban trong): ");
        TableService ts = new TableService();
        ts.addTable(new StandardTable("TEST_T1", 4)); // Tao ban ao
        BookingService bs = new BookingService(ts);

        Booking b = new Booking("B01", "C01", "TEST_T1", "2023-01-01", "18:00");
        try {
            bs.createBooking(b);
            // Kiem tra trang thai ban
            if (ts.getTableById("TEST_T1").getStatus() == TableStatus.BOOKED) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED (Trang thai ban khong doi)");
            }
        } catch (Exception e) {
            System.out.println("FAILED (" + e.getMessage() + ")");
        }
    }
    private static void testBookingFail() {
        System.out.print("Test 2 (Dat ban trung): ");
        TableService ts = new TableService();
        ts.addTable(new StandardTable("TEST_T2", 4));
        ts.updateTableStatus("TEST_T2", TableStatus.OCCUPIED); // Set ban ban

        BookingService bs = new BookingService(ts);
        Booking b = new Booking("B02", "C01", "TEST_T2", "2023-01-01", "19:00");

        try {
            bs.createBooking(b);
            System.out.println("FAILED (Khong bat duoc loi)");
        } catch (TableAlreadyBookedException e) {
            System.out.println("PASSED (Da bat duoc loi: " + e.getMessage() + ")");
        }
    }
    private static void testCalculateInvoice() {
        System.out.print("Test 3 (Tinh tien giam gia VIP): ");
        InvoiceService is = new InvoiceService();
        // Gia su hoa don 2 trieu, VIP giam 5% (100k) -> Con 1.9 trieu
        Invoice inv = is.createInvoice("INV01", "T01", 2000000, "2023-01-01");

        if (inv.getTotalAmount() == 1900000) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED (Ket qua: " + inv.getTotalAmount() + ")");
        }
    }
}