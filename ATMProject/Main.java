public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000, 1234);

        ATM atm = new ATM(account);

        atm.start();
    }
}