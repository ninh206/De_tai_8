public class MenuUI {
    private MenuService menuService;

    public MenuUI(MenuService menuService) {
        this.menuService = menuService;
    }

    public void handle() {
        while (true) {
            System.out.println("\n--- QUAN LY THUC DON ---");
            System.out.println("1. Xem thuc don");
            System.out.println("2. Them mon moi");
            System.out.println("3. Xoa mon");
            System.out.println("0. Quay lai");
            int choice = InputHelper.getInt("Chon");

            if (choice == 0) break;
            switch (choice) {
                case 1: showMenu(); break;
                case 2: addMenuItem(); break;
            }
        }
    }
    private void deleteMenuItem() {
        String id = InputHelper.getString("Nhap ID mon can xoa");
        try {
            menuService.deleteMenuItem(id);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
    private void showMenu() {
        for (MenuItem item : menuService.getAllItems()) {
            System.out.println(item);
        }
    }

    private void addMenuItem() {
        String id = InputHelper.getString("Ma mon");
        String name = InputHelper.getString("Ten mon");
        double price = InputHelper.getDouble("Gia tien");
        int type = InputHelper.getInt("Loai (1: Do an, 2: Nuoc uong)");

        MenuItem item;
        if (type == 1) item = new Food(id, name, price);
        else item = new Drink(id, name, price);

        menuService.addMenuItem(item);
        System.out.println("Them mon thanh cong!");
    }
}