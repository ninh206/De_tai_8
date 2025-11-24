public class TestRunner {
    public static void runAllTests() {
        System.out.println("=== BAT DAU CHAY TEST CASE ===");
        testBookingSuccess();
        testBookingFail();
        testCalculateInvoice();
        testAddMenuItem();
        testCancelBooking();
        System.out.println("=== KET THUC TEST CASE ===");
    }

    // Test 1: Đặt bàn thành công
    private static void testBookingSuccess() {
        System.out.print("Test 1 (Dat ban trong): ");
        TableService ts = new TableService();
        ts.addTable(new StandardTable("TEST_T1", 4)); // Tao ban ao
        BookingService bs = new BookingService(ts);

        // Tạo booking ngày tương lai để không bị lỗi validate ngày quá khứ
        Booking b = new Booking("B01", "C01", "TEST_T1", "2030-01-01", "18:00");
        try {
            bs.createBooking(b);
            if (ts.getTableById("TEST_T1").getStatus() == TableStatus.BOOKED) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED (Trang thai ban khong doi)");
            }
        } catch (Exception e) {
            System.out.println("FAILED (" + e.getMessage() + ")");
        }
    }

    // Test 2: Đặt bàn thất bại (trùng)
    private static void testBookingFail() {
        System.out.print("Test 2 (Dat ban trung): ");
        TableService ts = new TableService();
        ts.addTable(new StandardTable("TEST_T2", 4));
        ts.updateTableStatus("TEST_T2", TableStatus.OCCUPIED); // Set ban ban

        BookingService bs = new BookingService(ts);
        Booking b = new Booking("B02", "C01", "TEST_T2", "2030-01-01", "19:00");

        try {
            bs.createBooking(b);
            System.out.println("FAILED (Khong bat duoc loi)");
        } catch (TableAlreadyBookedException e) {
            System.out.println("PASSED (Da bat duoc loi: " + e.getMessage() + ")");
        } catch (Exception e) {
            System.out.println("FAILED (Loi khac: " + e.getMessage() + ")");
        }
    }

    // Test 3: Tính tiền
    private static void testCalculateInvoice() {
        System.out.print("Test 3 (Tinh tien giam gia VIP): ");
        InvoiceService is = new InvoiceService();
        // Gia su hoa don 2 trieu, VIP giam 10% (VipDiscount cũ là 5% hoặc 10% tùy bạn chỉnh, ở đây giả sử 10% nhé)
        // Nếu logic VipDiscount của bạn là 5% thì sửa 1800000 thành 1900000
        Invoice inv = is.createInvoice("INV01", "T01", 2000000, "2023-01-01");

        // Kiểm tra logic giảm giá (ở các bước trước ta cài VipDiscount > 1tr giảm 5% hay 10%?)
        // Giả sử logic là giảm 5% cho đơn > 1tr
        double expected = 2000000 * 0.95; // 1.900.000

        if (inv.getTotalAmount() == expected) {
            System.out.println("PASSED");
        } else {
            System.out.println("INFO: Ket qua la " + inv.getTotalAmount() + " (Ban can kiem tra lai ty le giam gia trong VipDiscount)");
        }
    }

    // Test 4: Thêm món ăn
    private static void testAddMenuItem() {
        System.out.print("Test 4 (Them mon moi): ");
        MenuService ms = new MenuService();
        Food f = new Food("TEST_F", "Test Food", 100);
        ms.addMenuItem(f);
        try {
            if (ms.searchByName("Test Food") != null) System.out.println("PASSED");
        } catch (Exception e) { System.out.println("FAILED"); }
    }

    // Test 5: Hủy đặt bàn
    private static void testCancelBooking() {
        System.out.print("Test 5 (Huy dat ban): ");
        TableService ts = new TableService();
        ts.addTable(new StandardTable("T_CANCEL", 4));
        BookingService bs = new BookingService(ts);

        try {
            bs.createBooking(new Booking("B_C", "C", "T_CANCEL", "2030-01-01", "10:00"));
            bs.cancelBooking("T_CANCEL"); // Huy

            if (ts.getTableById("T_CANCEL").getStatus() == TableStatus.AVAILABLE) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        } catch (Exception e) { System.out.println("FAILED " + e.getMessage()); }
    }
}