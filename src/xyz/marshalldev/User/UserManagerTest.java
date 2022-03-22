package xyz.marshalldev.User;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class UserManagerTest {

    private final UserManager u = new UserManager();
    private final Scanner scan = new Scanner(System.in);

    private User login(int id, String password) {
        User user = null;

        if (u.getUser(id) == null) {
            System.out.println("ID does not exist in the system.");
            System.exit(0);
        }

        while (!password.equals(u.getUser(id).getPassword())) {
            if (u.attempts >= 3) {
                // Project doesn't describe what it wants us to do if max attempts is exceeded, so assuming this.
                System.out.println("Maximum attempts exceeded. Terminating program.");
                System.exit(0);
            }
            System.out.println("Incorrect password. Attempt " + u.attempts + "/3");
            u.attempts++;
        }

        System.out.println("Login successful" + "\nWelcome to Customer Order System!");
        user = u.getUser(id);
        return user;
    }

    private String getPassword() {
        System.out.println("Enter a password: ");
        return scan.next();
    }

    @Test
    void loginIncorrectPassword() {
        u.addUser(new User(123, "Marshall@1"));
        login(123, "NotPassword");
    }

    @Test
    void loginIncorrectUser() {
        u.addUser(new User(123, "Marshall@1"));
        login(124, "NotPassword");
    }

    @Test
    void loginTrue() {
        u.addUser(new User(123, "Marshall@1"));
        login(123, "Marshall@1");
    }
}