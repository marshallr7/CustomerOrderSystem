package xyz.marshalldev.Bank;

public class Account {

    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance) {
        this.balance = this.balance + balance;
    }

    public void removeBalance(int balance) {
        this.balance = this.balance - balance;
    }
}
