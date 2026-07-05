import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyConverter {

    // Exchange rates relative to 1 USD
    static final double USD = 1.0;
    static final double PKR = 284.50;
    static final double INR = 83.50;
    static final double EUR = 0.92;
    static final double GBP = 0.79;
    static final double AED = 3.67;
    static final double JPY = 160.25;
    static final double CAD = 1.37;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n========================================");
            System.out.println("      CURRENCY CONVERTER SYSTEM");
            System.out.println("========================================");

            displayCurrencies();

            // Base Currency
            System.out.print("Select Base Currency (1-8): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.nextLine(); // Clear buffer
                continue;
            }

            int baseChoice = scanner.nextInt();
            scanner.nextLine();

            if (baseChoice < 1 || baseChoice > 8) {
                System.out.println("Invalid currency selection.");
                continue;
            }

            // Target Currency
            System.out.print("Select Target Currency (1-8): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.nextLine();
                continue;
            }

            int targetChoice = scanner.nextInt();
            scanner.nextLine();

            if (targetChoice < 1 || targetChoice > 8) {
                System.out.println("Invalid currency selection.");
                continue;
            }

            // Amount
            System.out.print("Enter Amount: ");

            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid amount.");
                scanner.nextLine();
                continue;
            }

            double amount = scanner.nextDouble();
            scanner.nextLine();

            // Reject negative amounts
            if (amount < 0) {
                System.out.println("Error: Negative amounts are not allowed.");
                continue;
            }

            double baseRate = getRate(baseChoice);
            double targetRate = getRate(targetChoice);

            // Cross-rate routing through USD
            double usdAmount = amount / baseRate;
            double convertedAmount = usdAmount * targetRate;

            // Banker's Rounding
            BigDecimal rounded = new BigDecimal(convertedAmount)
                    .setScale(2, RoundingMode.HALF_EVEN);

            System.out.println("\n----------- RESULT -----------");
            System.out.printf("%.2f %s = %s %s%n",
                    amount,
                    getCurrencyName(baseChoice),
                    rounded.toPlainString(),
                    getCurrencyName(targetChoice));
            System.out.println("------------------------------");

            System.out.print("\nDo another conversion? (Y/N): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("Y")) {
                System.out.println("\nThank you for using Currency Converter!");
                break;
            }
        }

        scanner.close();
    }

    // Display Menu
    public static void displayCurrencies() {

        System.out.println("1. USD (US Dollar)");
        System.out.println("2. PKR (Pakistani Rupee)");
        System.out.println("3. INR (Indian Rupee)");
        System.out.println("4. EUR (Euro)");
        System.out.println("5. GBP (British Pound)");
        System.out.println("6. AED (UAE Dirham)");
        System.out.println("7. JPY (Japanese Yen)");
        System.out.println("8. CAD (Canadian Dollar)");
    }

    // Return exchange rate
    public static double getRate(int choice) {

        switch (choice) {

            case 1:
                return USD;

            case 2:
                return PKR;

            case 3:
                return INR;

            case 4:
                return EUR;

            case 5:
                return GBP;

            case 6:
                return AED;

            case 7:
                return JPY;

            case 8:
                return CAD;

            default:
                return 1;
        }
    }

    // Return Currency Name
    public static String getCurrencyName(int choice) {

        switch (choice) {

            case 1:
                return "USD";

            case 2:
                return "PKR";

            case 3:
                return "INR";

            case 4:
                return "EUR";

            case 5:
                return "GBP";

            case 6:
                return "AED";

            case 7:
                return "JPY";

            case 8:
                return "CAD";

            default:
                return "";
        }
    }
}