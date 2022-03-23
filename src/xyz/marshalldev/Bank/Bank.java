package xyz.marshalldev.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private static final Map<Long, Account> accounts = new HashMap<>();      // Storage for user fund information. <Credit Card Number, Account>

    public static void addAccount(long creditCardNumber, Account account) {
        accounts.putIfAbsent(creditCardNumber, account);
    }

    public static void removeAccount(long creditCardNumber) {
        accounts.remove(creditCardNumber);
    }

    public static Account getAccount(long creditCardNumber) {
        return accounts.get(creditCardNumber);
    }

    public static int generateConfirmation() {
        Random rand = new Random();
        return rand.nextInt(1000, 10000);
    }

}
