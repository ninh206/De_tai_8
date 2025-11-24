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
    public Table suggestTable(int numberOfPeople) {
        for (Table t : tables) {
            if (t.getStatus() == TableStatus.AVAILABLE && t.getSeats() >= numberOfPeople) {
                return t;
            }
        }
        return null; // Khong tim thay
    }
    public void deleteTable(String id) throws TableNotFoundException {
        Table t = getTableById(id);
        if (t.getStatus() != TableStatus.AVAILABLE) {
            throw new RuntimeException("Khong the xoa ban dang co nguoi hoac da dat!");
        }
        tables.remove(t);
        tableRepo.save(tables); // Cap nhat file
        System.out.println("Da xoa ban: " + id);
    }
    public List<Table> getAllTables() { return tables; }
}