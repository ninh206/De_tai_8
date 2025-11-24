import java.util.ArrayList;
import java.util.List;

public class MenuRepository implements Persistable<MenuItem> {
    private static final String FILE_NAME = Constants.FILE_MENU;

    @Override
    public void save(List<MenuItem> items) {
        List<String> lines = new ArrayList<>();
        for (MenuItem item : items) {
            // TYPE,ID,NAME,PRICE
            String type = (item instanceof Food) ? "FOOD" : "DRINK";
            String line = type + "," + item.getId() + "," + item.getName() + "," + item.getPrice();
            lines.add(line);
        }
        CsvHelper.write(FILE_NAME, lines);
    }

    @Override
    public List<MenuItem> load() {
        List<MenuItem> items = new ArrayList<>();
        List<String> lines = CsvHelper.read(FILE_NAME);

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 4) continue;

            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            double price = Double.parseDouble(parts[3]);

            if (type.equals("FOOD")) {
                items.add(new Food(id, name, price));
            } else {
                items.add(new Drink(id, name, price));
            }
        }
        return items;
    }
}