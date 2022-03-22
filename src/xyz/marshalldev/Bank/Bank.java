package xyz.marshalldev.Bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private static Map<Long, Account> accounts = new HashMap<>();      // Storage for user fund information. <Credit Card Number, Account>

    public static void addAccount(long creditCardNumber, Account account) {
        accounts.putIfAbsent(creditCardNumber, account);
    }

    public static void removeAccount(long creditCardNumber) {
        accounts.remove(creditCardNumber);
    }

    public static Account getAccount(long creditCardNumber) {
        return accounts.get(creditCardNumber);
    }

}
