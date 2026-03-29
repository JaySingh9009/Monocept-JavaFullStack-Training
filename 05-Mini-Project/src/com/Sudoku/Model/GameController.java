package com.Sudoku.Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

    private Scanner scanner = new Scanner(System.in);

    public void start() {

        while (true) {

            printHeader();

            int choice = getInput();

            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    System.out.println("\nThank you for playing Sudoku.");
                    return;
                default:
                    printError("Invalid choice. Please select 1 or 2.");
            }
        }
    }

    private void printHeader() {
        System.out.println("\n=================================");
        System.out.println("           SUDOKU GAME           ");
        System.out.println("=================================");
        System.out.println("1. Play Game");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
    }

    private void printDivider() {
        System.out.println("---------------------------------");
    }

    private void printError(String message) {
        System.out.println("Error: " + message);
    }

    private void printSuccess(String messsage) {
        System.out.println(messsage);
    }

    private void playGame() {

        SudokuBoard board = new SudokuBoard();
        SudokuGenerator generator = new SudokuGenerator();
        SudokuValidator validator = new SudokuValidator(board);

        int difficulty = chooseDifficulty();

        System.out.println("\nGenerating Sudoku board...");
        generator.generateBoard(board, difficulty);

        while (true) {

            printDivider();
            board.displayBoard();

            if (board.isComplete()) {
                printDivider();
                if (validator.validateSudoku())
                    printSuccess("Congratulations! You solved the Sudoku.");
                else
                    printError("Board is filled but the solution is incorrect.");
                break;
            }

            handleMove(board, validator);
        }
    }

    private void handleMove(SudokuBoard board, SudokuValidator validator) {

        try {
            System.out.println("\nEnter your move (row column number)");
            System.out.println("Example: 1 3 9");
            System.out.print("Enter values (or 0 to exit): ");

            int row = scanner.nextInt();
            if (row == 0) {
                System.out.println("Returning to main menu...");
                return;
            }

            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (!isValid(row, col, num)) return;

            row--; col--;

            if (board.isCellFixed(row, col)) {
                printError("Cannot change a fixed cell.");
                return;
            }

            board.placeNumber(row, col, num);

            if (!validator.validateSudoku()) {
                printError("Invalid move. It violates Sudoku rules.");
                board.placeNumber(row, col, 0);
            } else {
                printSuccess("Move accepted.");
            }

        } catch (InputMismatchException e) {
            printError("Invalid input. Please enter numbers only.");
            scanner.nextLine();
        }
    }

    private int chooseDifficulty() {

        while (true) {

            printDivider();
            System.out.println("Select Difficulty Level");
            System.out.println("1. Easy   (60 cells filled)");
            System.out.println("2. Medium (50 cells filled)");
            System.out.println("3. Hard   (40 cells filled)");
            System.out.print("Enter your choice: ");

            int choice = getInput();

            if (choice >= 1 && choice <= 3)
                return choice;

            printError("Please choose between 1, 2, or 3.");
        }
    }

    private boolean isValid(int r, int c, int n) {

        if (r < 1 || r > 9 || c < 1 || c > 9) {
            printError("Row and column must be between 1 and 9.");
            return false;
        }

        if (n < 1 || n > 9) {
            printError("Number must be between 1 and 9.");
            return false;
        }

        return true;
    }

   
    private int getInput() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }
}