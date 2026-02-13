package com.loop;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        


        while (true) {
            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            boolean isGuessed = false;

            System.out.println("Maximum possible attempts -> " + maxAttempts);

            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Guess a number? ");
                int guess = scanner.nextInt();

                if (guess < randomNumber) {
                    System.out.println("Sorry, Too Low");
                } else if (guess > randomNumber) {
                    System.out.println("Sorry, Too High");
                } else {
                    System.out.println("You won: in attempt: " + attempts);
                    isGuessed = true;
                    break;
                }
            }

            if (!isGuessed) {
                System.out.println("Game Over! The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play the game again (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
