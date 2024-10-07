import java.util.ArrayList;

public class FruitManager extends BaseManager<Fruit> {

    public FruitManager(String filepath) {
        super(filepath);
    }

    @Override
    protected void addItemFromLine(String line) {
        String[] parts = line.split(", ");
        if (parts.length == 4) {
            int id = Integer.parseInt(parts[0].split(": ")[1]);
            String name = parts[1].split(": ")[1];
            double weight = Double.parseDouble(parts[2].split(": ")[1].replace(" kg", ""));
            double price = Double.parseDouble(parts[3].split(": ")[1].replace("$", ""));
            items.add(new Fruit(id, name, weight, price));
        }
    }

    public void create(Fruit fruit) {
        items.add(fruit);
        save();
    }

    public Fruit read(int id) {
        return items.stream().filter(fruit -> fruit.getId() == id).findFirst().orElse(null);
    }

    public void update(Fruit fruit) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == fruit.getId()) {
                items.set(i, fruit);
                save();
                break;
            }
        }
    }

    public void delete(int id) {
        items.removeIf(fruit -> fruit.getId() == id);
        save();
    }
}