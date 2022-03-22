package xyz.marshalldev;

import xyz.marshalldev.Bank.Account;
import xyz.marshalldev.Bank.Bank;
import xyz.marshalldev.Item.Item;
import xyz.marshalldev.Item.ItemManager;
import xyz.marshalldev.User.User;
import xyz.marshalldev.User.UserManager;

public class Main {

    private static User user = null;

    public static void main(String[] args) {
        UserManager u = new UserManager();
//        u.create();
//        user = u.login();
        createItems();
        User user1 = new User(1234, "Test@1", "Hello?", "Yes", "Marshall", "17 Westhaven", 123124);
        Bank.addAccount(123124, new Account(15000));
        u.addUser(user1);
        setUser(user1);
        Impl.driver();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Main.user = user;
    }

    private static void createItems() {
        Item item = new Item("Test", "This is a test item", 12.01, 9.99, false, 100);
        Item item2 = new Item("Test2", "This is a test item", 100.00, 99.99, true, 20);
        ItemManager.getInstance().addItems(item, item2);


    }
}
