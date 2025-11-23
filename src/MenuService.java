import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<MenuItem> menuItems;

    public MenuService() {
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public MenuItem searchByName(String name) throws MenuItemNotFoundException {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        throw new MenuItemNotFoundException("Khong tim thay mon: " + name);
    }

    public List<MenuItem> getAllItems() { return menuItems; }
    public void setMenuItems(List<MenuItem> menuItems) { this.menuItems = menuItems; }
}