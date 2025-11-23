import java.io.Serializable;

public enum TableStatus implements Serializable {
    AVAILABLE,  // Trống
    BOOKED,     // Đã đặt
    OCCUPIED    // Đang phục vụ
}