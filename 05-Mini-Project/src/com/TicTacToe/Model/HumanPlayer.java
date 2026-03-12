package com.TicTacToe.Model;


import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner;

    public HumanPlayer(String name, char symbol, Scanner scanner) {
        super(name, symbol);
        this.scanner = scanner;
    }

  
    @Override
    public void makeMove(Board board) {

        int position;

        while (true) {

            System.out.println(name + "'s Turn (" + symbol + ")");
            System.out.print("Choose position (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println(" Enter numbers only!");
                scanner.next();
                continue;
            }

            position = scanner.nextInt();

            if (!board.placeMove(position, symbol)) {
                System.out.println(" Invalid or already occupied position.");
            } else {
                break;
            }
        }
    }
}
