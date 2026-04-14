package com.TicTacToe.Model;

public class DisplayManager {
    
    public void printBoard(Board board) {
        int size = board.getSize();
        System.out.println("\n-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board.getCell(i, j) + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    public void printMessage(String message) {
        System.out.println(message);
    }
    
    public void printError(String error) {
        System.out.println("[Error] " + error);
    }
}
