import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        char playAgain;

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean won = false;

            System.out.println("\n=== Guess The Number Game ===");
            System.out.println("Guess a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!input.hasNextInt()) {
                    System.out.println("Wrong input! Please enter a number.");
                    input.next();
                    continue;
                }

                int guess = input.nextInt();
                attempts++;

                if (guess > secretNumber) {
                    System.out.println("Too high!");
                }
                else if (guess < secretNumber) {
                    System.out.println("Too low!");
                }
                else {
                    System.out.println("Congratulations!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    score++;
                    won = true;
                    break;
                }
            }

            if (!won) {
                System.out.println("Game Over!");
                System.out.println("The number was: " + secretNumber);
            }

            System.out.println("Current Score: " + score);

            System.out.print("Play another round? (Y/N): ");
            playAgain = input.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\n===== FINAL SCORE =====");
        System.out.println("Rounds Won: " + score);
        System.out.println("Thanks for playing!");

        input.close();
    }
}
