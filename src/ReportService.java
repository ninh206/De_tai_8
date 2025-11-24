import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
// Can them MenuService de lay danh sach mon
private MenuService menuService;

        public void setMenuService(MenuService ms) { this.menuService = ms; }

        public void printTop5BestSellers() {
            if (menuService == null) return;
            List<MenuItem> items = new ArrayList<>(menuService.getAllItems());
            // Sap xep giam dan theo salesCount
            items.sort((i1, i2) -> Integer.compare(i2.getSalesCount(), i1.getSalesCount()));

            System.out.println("\n--- TOP 5 MON BAN CHAY ---");
            for (int i = 0; i < Math.min(items.size(), 5); i++) {
                MenuItem item = items.get(i);
                System.out.println((i+1) + ". " + item.getName() + " - Da ban: " + item.getSalesCount());
            }
        }