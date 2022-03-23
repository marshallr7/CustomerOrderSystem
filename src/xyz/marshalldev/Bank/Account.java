package xyz.marshalldev.Bank;

public class Account {

    double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance = this.balance + balance;
    }

    public void removeBalance(double balance) {
        this.balance = this.balance - balance;
    }
}
