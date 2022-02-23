package xyz.marshalldev.Item;

import xyz.marshalldev.Cart;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {

    private Map<String, Item> items = new HashMap<>();

    public boolean purchase(Item item, int quantity, Cart cart) {
        if (!items.containsKey(item.getName())) {
            System.out.println("Item does not exist in system.");
            return false;
        }
        if (!(items.get(item.getName()).getStock() >= quantity)) {
            System.out.println("Attempted quantity exceeds amount in stock");
            return false;
        }
        purchase(item, quantity);
        cart.addItem(item, quantity);
        return true;
    }

    private void purchase(Item item, int quantity) {
        items.remove(item, quantity);
    }

}
