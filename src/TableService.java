import java.util.ArrayList;
import java.util.List;

public class TableService {
    private List<Table> tables;

    public TableService() {
        this.tables = new ArrayList<>();
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public Table getTableById(String id) throws TableNotFoundException {
        for (Table t : tables) {
            if (t.getId().equals(id)) return t;
        }
        throw new TableNotFoundException("Khong tim thay ban: " + id);
    }
    public void updateTableStatus(String id, TableStatus status) {
        try {
            Table t = getTableById(id);
            t.setStatus(status);
        } catch (TableNotFoundException e) {
        }
    }
    public List<Table> getAllTables() { return tables; }
    public void setTables(List<Table> tables) { this.tables = tables; }
}