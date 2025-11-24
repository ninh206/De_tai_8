public class TableUI {
    private TableService tableService;

    public TableUI(TableService tableService) {
        this.tableService = tableService;
    }

    public void handle() {
        while (true) {
            System.out.println("\n--- QUAN LY BAN AN ---");
            System.out.println("1. Danh sach ban");
            System.out.println("2. Them ban moi");
            System.out.println("3. Xoa ban");
            System.out.println("0. Quay lai");
            int choice = InputHelper.getInt("Chon");

            if (choice == 0) break;
            switch (choice) {
                case 1: showTables(); break;
                case 2: addTable(); break;
                case 3: deleteTable(); break;
                default: System.out.println("Chon sai!");
            }
        }
    }
    private void deleteTable() {
        String id = InputHelper.getString("Nhap ID ban can xoa");
        try {
            tableService.deleteTable(id);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
    private void showTables() {
        System.out.println("\n--- DANH SACH BAN ---");
        for (Table t : tableService.getAllTables()) {
            System.out.println(t);
        }
    }

    private void addTable() {
        String id = InputHelper.getString("Nhap ID ban (VD: T10)");
        // Đã đúng: seats >= 1
        int seats = InputHelper.getInt("So ghe", 1);
        // SỬA: Phải giới hạn type chỉ có thể là 1 hoặc 2 (chọn loại bàn)
        int type = InputHelper.getInt("Loai (1: Thuong, 2: VIP)", 1);

        // Tuy nhien, neu muon gioi han type chi la 1 HOAC 2, can viet mot loop:
        // while (type != 1 && type != 2) { type = InputHelper.getInt("..."); }
        // Tam thoi giu input helper don gian:

        Table t;
        if (type == 2) t = new VipTable(id, seats);
        else t = new StandardTable(id, seats);

        tableService.addTable(t);
        System.out.println("Da them ban thanh cong!");
    }
}