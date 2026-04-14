package com.TicTacToe.Model;

import com.TicTacToe.Exceptions.OutOfBoundsException;
import com.TicTacToe.Exceptions.InvalidMoveException;

public class Board {
    private final char[][] grid;
    private static final int SIZE = 3;

    public Board() {
        grid = new char[SIZE][SIZE];
        resetBoard();
    }

    public void resetBoard() {
        char count = '1';
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = count++;
            }
        }
    }

    public void setCell(int row, int column, char symbol) throws OutOfBoundsException, InvalidMoveException {
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE) {
            throw new OutOfBoundsException("Coordinates out of range. Use 0-2.");
        }
        if (grid[row][column] == 'X' || grid[row][column] == 'O') {
            throw new InvalidMoveException("This cell is already occupied.");
        }
        grid[row][column] = symbol;
    }

    public char getCell(int row, int column) {
        return grid[row][column];
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] != 'X' && grid[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getSize() {
        return SIZE;
    }
}