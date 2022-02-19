package xyz.marshalldev;

import xyz.marshalldev.User.User;
import xyz.marshalldev.User.UserManager;

public class Main {

    public static void main(String[] args) {
        UserManager u = new UserManager();
        u.create();
        User user = u.login();
    }
}
