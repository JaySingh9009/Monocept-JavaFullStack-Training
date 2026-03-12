package com.loop;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("===========================================");
        System.out.println("           NUMBER GUESSER GAME             ");
        System.out.println("===========================================");
        System.out.println("Guess a number between 1 and 100");
        System.out.println("Maximum attempts allowed: 5");
        System.out.println("===========================================\n");

        while (true) {

            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            boolean isGuessed = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                int guess;

                while (true) {

                    System.out.print("Attempt " + attempt + " of " + maxAttempts + " - Enter your guess: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next();
                        continue;
                    }

                    guess = scanner.nextInt();

                    if (guess < 1 || guess > 100) {
                        System.out.println("Number must be between 1 and 100. Try again.");
                        continue;
                    }

                    break;
                }

                if (guess < randomNumber) {
                    System.out.println("Result: Too Low");
                } 
                else if (guess > randomNumber) {
                    System.out.println("Result: Too High");
                } 
                else {
                    System.out.println("Congratulations. You guessed the number in attempt " + attempt);
                    isGuessed = true;
                    break;
                }

                System.out.println("-------------------------------------------");
            }

            if (!isGuessed) {
                System.out.println("Game Over");
                System.out.println("Correct Number was: " + randomNumber);
            }

            System.out.println("\n===========================================");

            String playAgain;

            while (true) {
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next();

                if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no")) {
                    break;
                }

                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }

            if (playAgain.equalsIgnoreCase("no")) {
                System.out.println("\n===========================================");
                System.out.println("           Thank You For Playing           ");
                System.out.println("===========================================");
                break;
            }

            System.out.println("\nStarting New Game...\n");
        }

        scanner.close();
    }
}