package xyz.marshalldev;

import xyz.marshalldev.Bank.Account;
import xyz.marshalldev.Bank.Bank;
import xyz.marshalldev.Item.Item;
import xyz.marshalldev.Item.ItemManager;
import xyz.marshalldev.User.User;
import xyz.marshalldev.User.UserManager;

import javax.swing.*;

public class GUI {
    JTextField create = new JTextField();
    JTextField login = new JTextField();

    JTextField id = new JTextField();
    JTextField password = new JPasswordField();
    JTextField answer = new JTextField();
    JTextField question = new JTextField();
    JTextField name = new JTextField();
    JTextField address = new JTextField();
    JTextField cardNumber = new JTextField();

    static JTextField quantity = new JTextField();
    static JTextField orderNum = new JTextField();

    public void drive() {

        if (Main.getUser() == null ) {
            String option = createOrLogin();

            switch (option) {
                case "Login" -> login();
                case "Create account" -> supplierOrReg();
            }
        } else {
            while(Main.getUser() != null) {
                loggedIn();
            }
        }
    }

    private void supplierOrReg() {
        String[] options = {"Supplier Account", "Regular Account", ""};

        String option = (String) JOptionPane.showInputDialog(
                null,
                "Select an Option: ",
                "Select an Option",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        switch (option) {
            case "Supplier Account" -> createSupplier();
            case "Regular Account" -> createUser();
        }
    }

    private String createOrLogin() {
        String[] options = {"Create account", "Login", ""};

        return (String) JOptionPane.showInputDialog(
                null,
                "Select an Option: ",
                "Select an Option",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
    }

    private void loggedIn() {
        String[] options = {"", "List Catalog Items", "Select Items", "View Cart", "View Orders", "Check Balance",
        "Checkout", "Logout", "View Stock", "Ship Order", "Process Order", "Terminate"};

        String selection = (String) JOptionPane.showInputDialog(
                null,
                "Select an Option: ",
                "Select an Option (View Console)",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        for (int i = 0; i < options.length; i++) {
            if (selection.equalsIgnoreCase(options[i])) {
                Impl.action(i);
            }
        }
    }

    private void login() {
        Object[] message = {
                "ID: ", id,
                "Password: ", password,
                "Security Question Answer: ", answer
        };
        JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        String idNum = id.getText();
        String pass = password.getText();
        String ans = answer.getText();


        if (UserManager.getInstance().checkID(Integer.parseInt(idNum)) ) {
            if (UserManager.getInstance().getUser(Integer.parseInt(idNum)).getPassword().equals(pass)) {
                if (ans.equals(UserManager.getInstance().getUser(Integer.parseInt(idNum)).getAnswer())) {
                    Main.setUser(UserManager.getInstance().getUser(Integer.parseInt(idNum)));
                    System.out.println("Logged into: " + Main.getUser().getId());
                    loggedIn();
                }
            }
            else {
                System.out.println("Incorrect password, please try again");
                login();
            }
        } else {
            System.out.println("Incorrect id, please try again");
            login();
        }
    }

    private void createUser() {
        Object[] message = {
                "ID: ", id,
                "Password: ", password,
                "Answer: ", answer,
                "Question: ", question,
                "Name: ", name,
                "Address: ", address,
                "Card Number: ", cardNumber
        };
        JOptionPane.showConfirmDialog(null, message, "Create Account", JOptionPane.OK_CANCEL_OPTION);

        int idNum = Integer.parseInt(id.getText());
        String pass = password.getText();
        String ans = answer.getText();
        String quest = question.getText();
        String n = name.getText();
        String addr = address.getText();
        long card = Long.parseLong(cardNumber.getText());
        User user = new User(idNum, pass, quest, ans, n, addr, card);
        Main.setUser(user);
        UserManager.getInstance().addUser(user);
        Bank.addAccount(card, new Account(Main.STARTING_BANK_BALANCE));
        System.out.println("Logged into: " + Main.getUser().getId());
        loggedIn();
    }

    private void createSupplier() {
        Object[] message = {
                "ID: ", id,
                "Password: ", password,
                "Answer: ", answer,
                "Question: ", question,
                "Name: ", name,
                "Address: ", address
        };
        JOptionPane.showConfirmDialog(null, message, "Create Account", JOptionPane.OK_CANCEL_OPTION);

        int idNum = Integer.parseInt(id.getText());
        String pass = password.getText();
        String ans = answer.getText();
        String quest = question.getText();
        String n = name.getText();
        String addr = address.getText();
        long card = 0;
        User user = new User(idNum, pass, quest, ans, n, addr, card);
        Main.setUser(user);
        UserManager.getInstance().addUser(user);
        Bank.addAccount(card, new Account(Main.STARTING_BANK_BALANCE));
        System.out.println("Logged into: " + Main.getUser().getId() +" (Supplier)");
        loggedIn();
    }

    public static void displayItems() {
        Object[] message = {
                "Xbox",
                "Playstation",
                "PC",
                "Calculator",
                "Monitor"
        };
        String item = (String) JOptionPane.showInputDialog(
                null,
                "Select an Option: ",
                "Select an Option",
                JOptionPane.QUESTION_MESSAGE,
                null,
                message,
                message[0]);
        getQuantity(ItemManager.getInstance().findItem(item));
    }

    private static void getQuantity(Item item) {
        Object[] message = {
                "How many " + item.getName(), quantity
        };
        JOptionPane.showConfirmDialog(null, message, "How many?", JOptionPane.OK_CANCEL_OPTION);
        ItemManager.getInstance().purchase(item, Integer.parseInt(quantity.getText()), Main.getUser().getCart());

    }

    public static void getOrder() {
        Object[] message = {
                "Enter order number: ", orderNum
        };
        JOptionPane.showConfirmDialog(null, message, "Enter order number", JOptionPane.OK_CANCEL_OPTION);
    }
}
