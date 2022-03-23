package xyz.marshalldev.Item;

import xyz.marshalldev.Cart;
import xyz.marshalldev.User.UserManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ItemManager {

    private final Map<String, Item> items = new HashMap<>();                  // Storage of items <ItemName - Item Object>
    private static ItemManager instance;

    public static ItemManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new ItemManager();
                }
            }
        }
        return instance;
    }

    public void purchase(Item item, int quantity, Cart cart) {
        if (!items.containsKey(item.getName())) {
            System.out.println("Item does not exist in system.");
            return;
        }
        cart.addItem(item, quantity);
    }


    public Item getAttemptedItemPurchase() {
        String userInput = getItemInput();

        if (userInput.equals("7")) {
            return null;
        }

        if (items.containsKey(userInput)) {
            return items.get(userInput);
        } else {
            System.out.println("Item not found... \n" +
                    "Enter another item name or 7 to exit.");
            return getAttemptedItemPurchase();
        }
    }

    private String getItemInput() {
        System.out.println("Enter the item name: ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public int getAttemptedPurchaseQuantity() {
        System.out.println("How many would you like to purchase?: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void addItems(Item... item) {
        for (Item i : item) {
            if (!items.containsKey(i.getName())) {
                items.put(i.getName(), i);
            }
        }
    }

    public void displayItems() {
        for (Item i : items.values()) {
            System.out.println(i.toString());
        }
    }
}
