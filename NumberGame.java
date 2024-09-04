package Intern;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int minNo = 1;
        int maxNo = 100;
        int maxAttempts = 10;
        int tRounds = 0;
        int tWins = 0;
        int tAttempts = 0;

        System.out.println("NUMBER GAME");
        System.out.println("------------");
        
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Random r = new Random();
            int randomNo = r.nextInt((maxNo - minNo) + 1) + minNo;

            System.out.println("Guess the number between " + minNo + " and " + maxNo + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.\n");

            int attempts = 0;
            boolean correctGuess = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess < randomNo) {
                    System.out.println("It's too low! Please try again.");
                } else if (guess > randomNo) {
                    System.out.println("It's too high! Please try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.\n");
                    correctGuess = true;
                    tWins++;
                    break;
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts) + ".\n");
            }

            if (!correctGuess) {
                System.out.println("Sorry, you didn't guess the number in " + maxAttempts + " attempts. The number was " + randomNo + ".\n");
            }

            tAttempts += attempts;
            tRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n");
        System.out.println("SCORE BOARD");
        System.out.println("------------");
        System.out.println("Thanks for playing!");
        System.out.println("Total rounds played: " + tRounds);
        System.out.println("Total wins: " + tWins);
        System.out.println("Total attempts: " + tAttempts);
        System.out.println("Average attempts per round: " + (tAttempts / (double) tRounds));
        System.out.println("Win rate: " + ((double) tWins / tRounds * 100) + "%");
    }
}

