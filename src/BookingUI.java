import java.util.UUID;

public class BookingUI {
    private BookingService bookingService;

    public BookingUI(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void handle() {
        while (true) {
            System.out.println("\n--- DAT BAN ---");
            System.out.println("1. Xem danh sach dat ban");
            System.out.println("2. Dat ban moi");
            System.out.println("3. Huy dat ban");
            System.out.println("0. Quay lai");
            int choice = InputHelper.getInt("Chon");

            if (choice == 0) break;
            switch (choice) {
                case 1: showBookings(); break;
                case 2: createBooking(); break;
                case 3: cancelBooking(); break;
            }
        }
    }

    private void showBookings() {
        for (Booking b : bookingService.getBookings()) {
            System.out.println(b);
        }
    }

    private void createBooking() {
        String custId = InputHelper.getString("Ten Khach Hang");
        String tableId = InputHelper.getString("Ma ban muon dat (VD: T01)");

        // Kiem tra ban trong truoc khi nhap tiep
        if (!bookingService.checkAvailability(tableId)) {
            System.out.println("Loi: Ban nay khong ton tai hoac da co nguoi dat!");
            return;
        }

        String date = InputHelper.getString("Ngay (yyyy-MM-dd)");
        String time = InputHelper.getString("Gio (HH:mm)");
        String bookingId = UUID.randomUUID().toString().substring(0, 8); // Tao ID ngau nhien

        Booking booking = new Booking(bookingId, custId, tableId, date, time);
        try {
            bookingService.createBooking(booking);
            System.out.println("Dat ban thanh cong! Ma dat ban: " + bookingId);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private void cancelBooking() {
        String tableId = InputHelper.getString("Nhap ID ban muon huy");
        bookingService.cancelBooking(tableId);
    }
}