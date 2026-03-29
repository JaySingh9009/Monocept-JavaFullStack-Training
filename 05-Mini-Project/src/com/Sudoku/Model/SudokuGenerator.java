package com.Sudoku.Model;

import java.util.*;

public class SudokuGenerator {

    private Random random = new Random();

    public void generateBoard(SudokuBoard board, int difficulty) {

        int filledCells;

        switch (difficulty) {

            case 1:
                filledCells = 60;
                break;

            case 2:
                filledCells = 50; 
                break;

            case 3:
                filledCells = 40; 
                break;

            default:
                filledCells = 50;
        }

        int cellsToRemove = 81 - filledCells;

        fillBoard(board.getGrid(), 0, 0);
        removeCells(board.getGrid(), cellsToRemove);

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {

                if(board.getGrid()[i][j] != 0)
                    board.setNumber(i,j,board.getGrid()[i][j],true);
            }
        }
    }

    private boolean fillBoard(int[][] grid, int row, int col) {

        if (row == 9)
            return true;

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col + 1) % 9;

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 9; i++)
            numbers.add(i);

        Collections.shuffle(numbers);

        for (int num : numbers) {

            if (isValid(grid, row, col, num)) {

                grid[row][col] = num;

                if (fillBoard(grid, nextRow, nextCol))
                    return true;

                grid[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int[][] grid, int row, int col, int number) {

        for (int i = 0; i < 9; i++)
            if (grid[row][i] == number || grid[i][col] == number)
                return false;

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[startRow + i][startCol + j] == number)
                    return false;

        return true;
    }

    private void removeCells(int[][] grid, int count) {

        while (count > 0) {

            int row = random.nextInt(9);
            int column = random.nextInt(9);

            if (grid[row][column] != 0) {

                grid[row][column] = 0;
                count--;
            }
        }
    }
}