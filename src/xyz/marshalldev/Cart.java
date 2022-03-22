package xyz.marshalldev;

import xyz.marshalldev.Item.Item;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private double SHIPPING_PRICE = 3;                      // Price for shipping

    private Map<Item, Integer> cart;      // Storage of items <Item - quantity>

    private double total;                                   // Total price of all cart items
    private boolean shipping;                               // Shipping if True, else pickup

    public Cart() {
        cart = new HashMap<>();
    }

    public void addItem(Item item, int amount) {
        if (!cart.containsKey(item)) {
            cart.put(item, amount);
        } else {
            cart.put(item, cart.get(item) + amount);
        }
        addToTotal(item, amount);
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
        removeFromTotal(item, amount);
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }

    private void addToTotal(Item item, int amount) {
        double price = 0;
        if (!item.isOnSale()) {
            price = item.getPrice();
        } else {
            price = item.getSalePrice();
        }

        total += price*amount;
    }

    private void removeFromTotal(Item item, int amount) {
        double price = 0;
        if (!item.isOnSale()) {
            price = item.getPrice();
        } else {
            price = item.getSalePrice();
        }

        total -= price*amount;
    }

    public boolean isShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public void display() {
        for (Item i : cart.keySet()) {
            System.out.println(cart.get(i) + "x " + i.getName());
        }
    }
}
