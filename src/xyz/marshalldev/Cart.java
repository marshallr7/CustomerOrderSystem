package xyz.marshalldev;

import xyz.marshalldev.Item.Item;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private double SHIPPING_PRICE = 3;                      // Price for shipping

    private Map<Item, Integer> cart = new HashMap<>();      // Storage of items <Item - quantity>

    private double total;                                   // Total price of all cart items
    private boolean shipping;                               // Shipping if True, else pickup

    public void addItem(Item item, int amount) {
        // TODO add checks for what to do if item is already in cart
        cart.putIfAbsent(item, amount);
    }

    public void removeItem(Item item, int amount) {
        // if cart doesn't contain the item
        if (!cart.containsKey(item)) {
            return;
        }
        // if amount won't fully remove all quantity of the item from the cart
        if (cart.get(item)-1 >= amount) {
            cart.put(item, cart.get(item) - amount);
            return;
        }
        cart.remove(item);
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }

    // TODO maybe this isn't the best way to handle this. Maybe update total when a user adds or removes an item from the cart
    public void calculateTotal() {
        for (Item i : cart.keySet()) {
            double price = i.getPrice();
            int quantity = cart.get(i);
            this.total += price*quantity;
        }
    }

    @Override
    public String toString() {
        return cart.toString();
    }
}
