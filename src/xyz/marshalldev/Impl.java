package xyz.marshalldev;

import xyz.marshalldev.Bank.Bank;
import xyz.marshalldev.Item.Item;
import xyz.marshalldev.Item.ItemManager;
import xyz.marshalldev.User.User;
import xyz.marshalldev.User.UserManager;

import java.util.Scanner;

public class Impl {

    public static void driver() {
        System.out.println("What would you like to do?");
        if (Main.getUser() != null) {
            System.out.println("1) Browse items");
            System.out.println("2) Select items");
            System.out.println("3) View cart");
            System.out.println("4) Check order");
            System.out.println("5) Check balance");
            System.out.println("6) Checkout");
            System.out.println("7) Logout");
            System.out.println("10) Exit");
        } else {
            System.out.println("1) Create user");
            System.out.println("2) Login");
            System.out.println("10) Exit");
        }

        int option = 0;
        while (option != 10) {
            option = getOption();
            action(option);
            System.out.println("\n\n\n");
            driver();
        }
    }

    private static int getOption() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static void action(int option) {
        UserManager usermanager = UserManager.getInstance();
        if (Main.getUser() != null) {
            User user = Main.getUser();
            switch (option) {
                // browse
                case 1:
                    System.out.println("List of all catalog items: ");
                    ItemManager.getInstance().displayItems();
                    break;
                    // select
                case 2:
                    Item item = ItemManager.getInstance().getAttemptedItemPurchase();
                    int quantity = ItemManager.getInstance().getAttemptedPurchaseQuantity();
                    ItemManager.getInstance().purchase(item, quantity, Main.getUser().getCart());
                    System.out.println("Successfully added " + quantity + "x " + item.getName() + " to your cart.");
                    break;
                case 3:
                    if (user.getCart() != null) {
                        user.getCart().display();
                    } else {
                        System.out.println("Your cart is empty.");
                    }
                    break;
                    //check order
                case 4:
                    if (!user.getOrders().isEmpty()) {
                        user.getOrders().forEach(o -> {
                            System.out.println("Order number: " + o.getOrderNumber());
                            System.out.println("\tDate: " + o.getDate());
                            o.getCart().display();
                        });
                    } else {
                        System.out.println("You have no orders");
                    }
                    break;
                    //check balance
                case 5:
                    System.out.println("Bank balance: $" + Bank.getAccount(user.getCardNumber()).getBalance());
                    break;
                    // checkout
                case 6:
                    if (user.getCart().isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        user.getCart().setTotal(user.getCart().getTotal()*user.getCart().getTAX_RATE());
                        if (Bank.getAccount(user.getCardNumber()).getBalance() >= user.getCart().getTotal()) {
                            int orderNumber = Bank.generateConfirmation();
                            Bank.getAccount(user.getCardNumber()).removeBalance(user.getCart().getTotal());
                            Order order = new Order(user.getCart(), orderNumber);
                            user.addOrder(order);
                            user.setCart(new Cart());
                            System.out.println("Order successfully placed, your confirmation number is: " + orderNumber);
                        } else {
                            System.out.println("Insufficient funds, can not complete purchase.");
                        }
                    }
                    break;
                case 7:
                    usermanager.logout();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } else {
            switch (option) {
                case 1 -> usermanager.create();
                case 2 -> Main.setUser(usermanager.login());
                case 3 -> System.exit(0);
                default -> System.out.println("Error... Invalid input.");
            }
        }
    }

}
