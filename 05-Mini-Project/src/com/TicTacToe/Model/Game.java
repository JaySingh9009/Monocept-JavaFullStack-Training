package com.TicTacToe.Model;

import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Board board;
    private Scanner scanner;

 
    public Game() {

        scanner = new Scanner(System.in);
        board = new Board();
        setupGame();
    }

    private void setupGame() {

        int choice;

        while (true) {

            System.out.println("Choose Mode:");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Enter numbers only.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2)
                break;
            else
                System.out.println("Please select 1 or 2.");
        }

        if (choice == 1) {

            System.out.print("Enter Player 1 Name: ");
            String n1 = scanner.nextLine();

            System.out.print("Enter Player 2 Name: ");
            String n2 = scanner.nextLine();

            player1 = new HumanPlayer(n1, 'X', scanner);
            player2 = new HumanPlayer(n2, 'O', scanner);

        } else {

            System.out.print("Enter Your Name: ");
            String n1 = scanner.nextLine();

            player1 = new HumanPlayer(n1, 'X', scanner);
            player2 = new ComputerPlayer("Computer", 'O');
        }
    }

    public void start() {

        Player currentPlayer = player1;

        while (true) {

            board.printBoard();
            currentPlayer.makeMove(board);

            if (board.checkWin(currentPlayer.getSymbol())) {

                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {

                board.printBoard();
                System.out.println("It's a Draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}