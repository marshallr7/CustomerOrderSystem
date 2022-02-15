package xyz.marshalldev.User;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private Map<Integer, User> users = new HashMap<>();

    public User get(int id) {
        return users.get(id);
    }
}
