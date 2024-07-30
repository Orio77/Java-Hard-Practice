package oop.exercise3_encapsulation.scenario3;

import java.util.Stack;

public class BankAccount {
    private int balance;
    private Stack<String> transactionHistory;
    private int password;

    public BankAccount(int accountNumber, String password) {
        balance = 0;
        transactionHistory = new Stack<>();
        setAccountNumber(accountNumber);
        this.password = password.hashCode();
    }

    public int getBalance() {
        return balance;
    }
    public Stack<String> getTransactionHistory() {
        return transactionHistory;
    }
    private void setBalance(int balance) {
        if (balance > 0)
            this.balance = balance;
    }    
    private void setAccountNumber(int accountNumber) {
        if (Integer.toString(accountNumber).length() == 8) {
        }
    }


    public final void deposit(int money) {
        setBalance(money);
        transactionHistory.push("Deposited: " + money);
    }
    public final void withdraw(int money) {
        if ((balance - money) > 0) {
            setBalance(money);
            transactionHistory.push("Withdrawed: " + money);
        }
    }
    public final void showTransactionHistory() {
        System.out.println(transactionHistory);
    }
    public boolean login(String password) {
        if (password.hashCode() == this.password)
            return true;
        
        return false;
    }
}
