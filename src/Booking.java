import java.io.Serializable;

public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookingId;
    private String customerId;
    private String tableId;
    private String date; // yyyy-MM-dd
    private String time; // HH:mm

    public Booking(String bookingId, String customerId, String tableId, String date, String time) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.tableId = tableId;
        this.date = date;
        this.time = time;
    }

    // --- CÁC HÀM GETTER (Bắt buộc phải có để Repository đọc dữ liệu) ---
    public String getBookingId() { return bookingId; }

    public String getCustomerId() { return customerId; }

    public String getTableId() { return tableId; }

    public String getDate() { return date; }

    // ĐÂY LÀ HÀM BẠN ĐANG THIẾU:
    public String getTime() { return time; }
    // ------------------------------------------------------------------

    @Override
    public String toString() {
        return "Booking [" + bookingId + "] Khách: " + customerId + " - Bàn: " + tableId + " lúc " + time + " " + date;
    }
}