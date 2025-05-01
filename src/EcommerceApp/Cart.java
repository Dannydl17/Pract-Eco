package EcommerceApp;

import EcommerceApp.exception.InvalidItemName;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();


    public void add(Item item) {
        items.add(item);
    }

    public int count() {
        return items.size();
    }

    public void Remove(String name) {
        Item item = findItemByName(name);
        items.remove(item);
    }

    private Item findItemByName(String name) {
        for (Item item:items) {
            if (item.getItemName().equals(name)) {
                return item;
            }
        }
        throw new InvalidItemName("Item not found");
    }
}
