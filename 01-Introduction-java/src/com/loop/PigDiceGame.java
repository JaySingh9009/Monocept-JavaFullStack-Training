package com.loop;

import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        final int TARGET = 20;

        while (true) {

            int totalScore = 0;
            int turn = 1;

            System.out.println("=================================================");
            System.out.println("                    PIG DICE GAME                ");
            System.out.println("=================================================");
            System.out.println("Rules:");
            System.out.println("1. The goal is to reach a total score of " + TARGET + ".");
            System.out.println("2. Each turn you can choose to roll or hold.");
            System.out.println("3. If you roll a 1, you lose all points for that turn.");
            System.out.println("4. If you hold, your turn score is added to total score.");
            System.out.println("=================================================\n");

            while (totalScore < TARGET) {

                int turnScore = 0;

                System.out.println("-----------------------------------------------");
                System.out.println("Turn: " + turn);
                System.out.println("Current Total Score: " + totalScore);
                System.out.println("-----------------------------------------------");

                while (true) {

                    String choice;

                    while (true) {
                        System.out.print("Choose an action (roll/hold) [r/h]: ");
                        choice = scanner.next().toLowerCase();

                        if (choice.equals("r") || choice.equals("h")) {
                            break;
                        }

                        System.out.println("Invalid input. Enter 'r' to roll or 'h' to hold.");
                    }

                    if (choice.equals("r")) {

                        int die = random.nextInt(6) + 1;
                        System.out.println("Die value: " + die);

                        if (die == 1) {
                            System.out.println("Turn ended. No points earned.");
                            turnScore = 0;
                            break;
                        }

                        turnScore += die;
                        System.out.println("Turn Score: " + turnScore);
                    }

                    else {

                        totalScore += turnScore;

                        System.out.println("Turn Score Saved: " + turnScore);
                        System.out.println("Updated Total Score: " + totalScore);
                        break;
                    }

                    System.out.println("-----------------------------------------------");
                }

                System.out.println();
                turn++;
            }

            System.out.println("=================================================");
            System.out.println("Target reached.");
            System.out.println("You finished the game in " + (turn - 1) + " turns.");
            System.out.println("=================================================\n");

            String playAgain;

            while (true) {
                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().toLowerCase();

                if (playAgain.equals("yes") || playAgain.equals("no")) {
                    break;
                }

                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }

            if (playAgain.equals("no")) {
                System.out.println("\n=================================================");
                System.out.println("Thank you for playing the Pig Dice Game.");
                System.out.println("=================================================");
                break;
            }

            System.out.println("\nStarting a new game...\n");
        }

        scanner.close();
    }
}