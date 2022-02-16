package xyz.marshalldev.User;

import xyz.marshalldev.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {

    private static final Map<Integer, User> users = new HashMap<>();        // User storage - <User ID - User Object>
    private final Scanner scan = new Scanner(System.in);
    private final int attempts = 0;                                         // Number of attempts user has taken to log in

    public void addUser(User user) {
        users.putIfAbsent(user.getId(), user);
    }

    public User get(int id) {
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

    public void login() {
        int id;
        String password;
        User user = null;

        System.out.println("Enter your ID: ");
        id = Integer.parseInt(scan.next());
        System.out.println("Enter your password: ");
        password = scan.next();

        if (get(id) == null || !password.equals(get(id).getPassword())) {

        }
    }

    private int getID() {
        System.out.println("Enter an id: ");
        int id = Integer.parseInt(scan.next());
        return id;
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
