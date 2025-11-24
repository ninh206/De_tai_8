import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements Persistable<Invoice> {
    private static final String FILE_NAME = "invoices.csv";

    @Override
    public void save(List<Invoice> invoices) {
        List<String> lines = new ArrayList<>();
        for (Invoice inv : invoices) {
            lines.add(inv.toString());
        }
        CsvHelper.write(FILE_NAME, lines);
    }

    @Override
    public List<Invoice> load() {
        return new ArrayList<>(); // Tam thoi chua can load hoa don len de xu ly
    }
}