package xyz.marshalldev.User;

import xyz.marshalldev.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {

    private static final Map<Integer, User> users = new HashMap<>();        // User storage - <User ID - User Object>
    private final Scanner scan = new Scanner(System.in);
    int attempts = 1;                                         // Number of attempts user has taken to log in

    public void addUser(User user) {
        users.putIfAbsent(user.getId(), user);
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public void create() {
        int id = 0;
        String password = null;
        String question;
        String answer;

        id = getID();
        while (checkID(id) || id == 0) {
            System.out.println("ID value is already taken");
            id = getID();
        }

        while (StringUtils.checkPassword(password)) {
            password = getPassword();
        }

        System.out.println("Enter a security question: ");
        question = scan.next();
        System.out.println("Enter an answer: ");
        answer = scan.next();
        User user = new User(id, password, question, answer);
        addUser(user);
    }

    public User login() {
        int id;
        String password;
        User user = null;

        id = getID();
        password = getPassword();

        if (getUser(id) == null || !users.containsKey(id)) {
            System.out.println("ID does not exist in the system.");
            System.exit(0);
        }

        while (!password.equals(getUser(id).getPassword())) {
            if (attempts >= 3) {
                // Project doesn't describe what it wants us to do if max attempts is exceeded, so assuming this.
                System.out.println("Maximum attempts exceeded. Terminating program.");
                System.exit(0);
            }
            System.out.println("Incorrect password. Attempt " + attempts + "/3");
            attempts++;
            password = getPassword();
        }

        System.out.println("Login successful" + "\nWelcome to Customer Order System!");
        user = getUser(id);
        return user;
    }

    private int getID() {
        System.out.println("Enter an id: ");
        return Integer.parseInt(scan.next());
    }

    private String getPassword() {
        System.out.println("Enter a password: ");
         return scan.next();
    }

    // Check if ID exists in users
    // If it does, return true
    private boolean checkID(int id) {
        return users.containsKey(id);
    }
}
