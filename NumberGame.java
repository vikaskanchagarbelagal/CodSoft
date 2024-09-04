import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int min = 1; // minimum value
        int max = 100; // maximum value
        int maxAttempts = 5; // maximum number of attempts

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        int totalRounds = 0;
        int totalWins = 0;
        int totalAttempts = 0;

        while (playAgain) {
            Random rand = new Random();
            int randomNumber = rand.nextInt((max - min) + 1) + min;

            System.out.println("I'm thinking of a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalWins++;
                    break;
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number in " + maxAttempts + " attempts. The number was " + randomNumber + ".");
            }

            totalAttempts += attempts;
            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        // Display final score
        System.out.println("Thanks for playing!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total wins: " + totalWins);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Average attempts per round: " + (totalAttempts / (double) totalRounds));
        System.out.println("Win rate: " + ((double) totalWins / totalRounds * 100) + "%");
    }
}
