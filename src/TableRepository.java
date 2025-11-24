import java.util.ArrayList;
import java.util.List;

public class TableRepository implements Persistable<Table> {
    private static final String FILE_NAME = "tables.csv";

    @Override
    public void save(List<Table> tables) {
        List<String> lines = new ArrayList<>();
        for (Table t : tables) {
            // Format: TYPE,ID,SEATS,STATUS
            String type = (t instanceof VipTable) ? "VIP" : "STD";
            String line = type + "," + t.getId() + "," + t.getSeats() + "," + t.getStatus();
            lines.add(line);
        }
        CsvHelper.write(FILE_NAME, lines);
    }

    @Override
    public List<Table> load() {
        List<Table> tables = new ArrayList<>();
        List<String> lines = CsvHelper.read(FILE_NAME);

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 4) continue;

            String type = parts[0];
            String id = parts[1];
            int seats = Integer.parseInt(parts[2]);
            String statusStr = parts[3];

            Table table;
            if (type.equals("VIP")) {
                table = new VipTable(id, seats);
            } else {
                table = new StandardTable(id, seats);
            }

            // Restore status
            try {
                table.setStatus(TableStatus.valueOf(statusStr));
            } catch (IllegalArgumentException e) {
                table.setStatus(TableStatus.AVAILABLE);
            }

            tables.add(table);
        }
        return tables;
    }
}