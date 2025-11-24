import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements Persistable<Booking> {
    private static final String FILE_NAME = "bookings.csv";

    @Override
    public void save(List<Booking> bookings) {
        List<String> lines = new ArrayList<>();
        for (Booking b : bookings) {
            lines.add(b.getBookingId() + "," +
                    "CUST_ID_HOLDER" + "," + // Tam thoi chua luu ID khach o object Booking
                    b.getTableId() + "," +
                    b.getDate() + "," +
                    b.getTime());
        }
        CsvHelper.write(FILE_NAME, lines);
    }

    @Override
    public List<Booking> load() {
        List<Booking> bookings = new ArrayList<>();
        List<String> lines = CsvHelper.read(FILE_NAME);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 5) {
                // Booking(id, custId, tableId, date, time)
                bookings.add(new Booking(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        }
        return bookings;
    }
}