import java.util.ArrayList;

public class BankAccount {

    private double balance;
    private final int pin;
    private ArrayList<String> transactionHistory;

    public BankAccount(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: $" + balance);
    }

    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        balance += amount;
        transactionHistory.add("Deposited: $" + amount);

        System.out.println("\nDeposit Successful.");
        System.out.printf("Current Balance: $%.2f%n", balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("\nInsufficient Funds.");
            transactionHistory.add("Failed Withdrawal: $" + amount);
            return;
        }

        balance -= amount;
        transactionHistory.add("Withdrawn: $" + amount);

        System.out.println("\nWithdrawal Successful.");
        System.out.printf("Remaining Balance: $%.2f%n", balance);
    }

    public void checkBalance() {
        System.out.printf("\nCurrent Balance: $%.2f%n", balance);
    }

    public void showTransactionHistory() {

        System.out.println("\n========== Transaction History ==========");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}