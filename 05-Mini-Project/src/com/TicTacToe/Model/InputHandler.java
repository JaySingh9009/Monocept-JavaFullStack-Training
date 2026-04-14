package com.TicTacToe.Model;

import com.TicTacToe.Exceptions.InvalidInputException;
import java.util.Scanner;

public class InputHandler {
    
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }
    
    public int[] readAndValidateMove() throws InvalidInputException {
        System.out.print("Enter cell number (1-9): ");
        String line = scanner.nextLine().trim();
        
        try {
            int cell = Integer.parseInt(line);
            if (cell < 1 || cell > 9) {
                throw new InvalidInputException("Cell number must be between 1 and 9.");
            }
            int row = (cell - 1) / 3;
            int col = (cell - 1) % 3;
            return new int[]{row, col};
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input type. Expected integers.");
        }
    }
    
    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    public String readValidPlayerName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            if (name.matches("^[a-zA-Z]+$")) {
                return name;
            } else {
                System.out.println("Invalid name. Please use alphabets only.");
            }
        }
    }
    
    public int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
            System.out.print(prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }
}
