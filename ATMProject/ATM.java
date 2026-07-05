import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("==================================");
        System.out.println("      Welcome to Java ATM");
        System.out.println("==================================");

        if (!login()) {
            System.out.println("\nToo many incorrect PIN attempts.");
            System.out.println("Account has been locked.");
            return;
        }

        int choice;

        do {

            displayMenu();
            choice = getIntegerInput();

            switch (choice) {

                case 1:
                    depositMoney();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("\nThank you for using our ATM.");
                    break;

                default:
                    System.out.println("\nInvalid Choice.");
            }

        } while (choice != 5);
    }

    private boolean login() {

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter your 4-digit PIN: ");

            int enteredPin = getIntegerInput();

            if (account.validatePin(enteredPin)) {
                System.out.println("\nLogin Successful!");
                return true;
            }

            attempts--;
            System.out.println("Incorrect PIN.");
            System.out.println("Attempts Remaining: " + attempts);
        }

        return false;
    }

    private void displayMenu() {

        System.out.println("\n========== ATM MENU ==========");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void depositMoney() {

        System.out.print("Enter deposit amount: ");

        double amount = getDoubleInput();

        account.deposit(amount);
    }

    private void withdrawMoney() {

        System.out.print("Enter withdrawal amount: ");

        double amount = getDoubleInput();

        account.withdraw(amount);
    }

    private int getIntegerInput() {

        while (!scanner.hasNextInt()) {

            System.out.println("Invalid input. Please enter a valid number.");

            scanner.nextLine(); // Clears buffer to prevent infinite loop

            System.out.print("Try Again: ");
        }

        int value = scanner.nextInt();
        scanner.nextLine(); // Clears remaining newline

        return value;
    }

    private double getDoubleInput() {

        while (!scanner.hasNextDouble()) {

            System.out.println("Invalid amount. Please enter a valid number.");

            scanner.nextLine(); // Clears buffer

            System.out.print("Try Again: ");
        }

        double value = scanner.nextDouble();
        scanner.nextLine(); // Clears remaining newline

        return value;
    }
}