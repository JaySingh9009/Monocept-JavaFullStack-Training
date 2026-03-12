package com.TicTacToe.Main;

import java.util.Scanner;
import com.TicTacToe.Model.Game;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("\n===== TIC TAC TOE =====");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Enter numbers only.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    Game game = new Game();   
                    game.start();
                    break;

                case 2:
                    System.out.println("Goodbye ");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}