package xyz.marshalldev;

import xyz.marshalldev.Item.Item;
import xyz.marshalldev.Item.ItemManager;
import xyz.marshalldev.User.User;
import xyz.marshalldev.User.UserManager;

public class Main {

    private static User user = null;
    public static final double STARTING_BANK_BALANCE = 15000d;

    public static void main(String[] args) {
        createTestItems();
        createTestUsers();
        Impl.driver();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Main.user = user;
    }


    private static void createTestItems() {
        Item xbox = new Item("Xbox", "Xbox series X", 600, 550, false);
        Item playstation = new Item("Playstation", "Playstation 5", 900, 750, true);
        Item pc = new Item("PC", "Some pc", 3000.00, 2700, false);
        Item calculator = new Item("Calculator", "TI Inspire", 100.00, 99.99, false);
        Item monitor = new Item("Monitor", "some monitor", 200.00, 150.00, false);
        ItemManager.getInstance().addItems(xbox, playstation, pc, calculator, monitor);
    }

    private static void createTestUsers() {
        User user1 = new User(123, "Test@1", "Test Question", "Answer", "Pablo", "123 test street", 123123);
        User user2 = new User(1234, "Test@1", "Test Question", "Answer", "Not Pablo", "123 street", 12312323);
        User user3 = new User(12345, "Test@1", "Test Question", "Answer", "Who?", "123 t", 12391123);
        User user4 = new User(122, "Test@1", "Test Question", "Answer", "Juan", "1 test street", 12);
        User user5 = new User(126, "Test@1", "Test Question", "Answer", "Umm", "No", 1415);
        UserManager.getInstance().addUsers(user1, user2, user3, user4, user5);
    }
}
