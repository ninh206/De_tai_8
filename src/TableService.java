import java.util.List;

public class TableService {
    private List<Table> tables;
    private TableRepository tableRepo; // Them Repository

    public TableService() {
        this.tableRepo = new TableRepository();
        this.tables = tableRepo.load(); // Load tu file khi khoi tao
    }

    public void addTable(Table table) {
        tables.add(table);
        tableRepo.save(tables); // Luu ngay sau khi them
    }

    public Table getTableById(String id) throws TableNotFoundException {
        for (Table t : tables) {
            if (t.getId().equalsIgnoreCase(id)) return t;
        }
        throw new TableNotFoundException("Khong tim thay ban: " + id);
    }

    public void updateTableStatus(String id, TableStatus status) {
        try {
            Table t = getTableById(id);
            t.setStatus(status);
            tableRepo.save(tables); // Luu lai trang thai moi vao file
        } catch (TableNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Table> getAllTables() { return tables; }
}