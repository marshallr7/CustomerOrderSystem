package xyz.marshalldev.User;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private static UserCache instance;
    private static Map<Integer, User> users = new HashMap<>();

    public static UserCache getInstance() {
        if (instance == null) {
            synchronized (UserCache.class) {
                if (instance == null) {
                    instance = new UserCache();
                }
            }
        }
        return instance;
    }

    public User get(int id) {
        return users.get(id);
    }

    public void addUser(User user) {
        users.putIfAbsent(user.getId(), user);
    }
}
