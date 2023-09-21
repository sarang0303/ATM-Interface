package atm_interface;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	
	private double balance;
    private List<Transaction> transactionHistory;

    public BankAccount() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction(Transaction.TransactionType.DEPOSIT, amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction(Transaction.TransactionType.WITHDRAW, amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (balance >= amount) {
            balance -= amount;
            receiver.deposit(amount);
            transactionHistory.add(new Transaction(Transaction.TransactionType.TRANSFER, amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

}
