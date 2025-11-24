import java.util.ArrayList;
import java.util.List;

public class DataSeeder {

    public static void generateData() {
        // 1. Tao Ban An (15 ban)
        TableRepository tableRepo = new TableRepository();
        List<Table> tables = new ArrayList<>();
        for (int i = 1; i <= 10; i++) tables.add(new StandardTable("T" + i, 4));
        for (int i = 11; i <= 15; i++) tables.add(new VipTable("VIP" + i, 6));
        tableRepo.save(tables);

        // 2. Tao Menu (20 mon)
        MenuRepository menuRepo = new MenuRepository();
        List<MenuItem> items = new ArrayList<>();
        items.add(new Food("F01", "Pho Bo", 50000));
        items.add(new Food("F02", "Bun Cha", 45000));
        items.add(new Drink("D01", "Tra Da", 5000));
        items.add(new Drink("D02", "Cafe", 25000));
        // ... (Them cho du 20 mon neu can)
        menuRepo.save(items);

        System.out.println("--> Da khoi tao du lieu mau (tables.csv, menu.csv)!");
    }
}