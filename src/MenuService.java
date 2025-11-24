import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.ArrayList;
public class MenuService {
    private List<MenuItem> menuItems;
    private MenuRepository menuRepo;

    public MenuService() {
        this.menuRepo = new MenuRepository();
        this.menuItems = menuRepo.load(); // Load data
    }
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        menuRepo.save(menuItems);
    }

    public void deleteMenuItem(String id) throws MenuItemNotFoundException {
        MenuItem item = null;
        for (MenuItem m : menuItems) {
            if (m.getId().equals(id)) {
                item = m;
                break;
            }
        }
        if (item == null) throw new MenuItemNotFoundException("Khong tim thay mon: " + id);

        menuItems.remove(item);
        menuRepo.save(menuItems);
        System.out.println("Da xoa mon: " + item.getName());
    }

    public MenuItem searchByName(String name) throws MenuItemNotFoundException {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        throw new MenuItemNotFoundException("Khong tim thay mon: " + name);
    }

    public List<MenuItem> getAllItems() {
        return menuItems;
    }
}