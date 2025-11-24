import java.util.List;

public class MenuService {
    private List<MenuItem> menuItems;
    private MenuRepository menuRepo;

    public MenuService() {
        this.menuRepo = new MenuRepository();
        this.menuItems = menuRepo.load(); // Load data
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
        menuRepo.save(menuItems); // Save data
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
}