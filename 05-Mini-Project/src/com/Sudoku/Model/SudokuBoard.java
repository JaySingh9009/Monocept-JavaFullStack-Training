package com.Sudoku.Model;

public class SudokuBoard {

    private int[][] grid = new int[9][9];
    private boolean[][] fixedCells = new boolean[9][9];

    public int[][] getGrid() {
        return grid;
    }

    public boolean isCellFixed(int row,int column) {
        return fixedCells[row][column];
    }

    public void setNumber(int row,int column,int number,boolean fixed) {
        grid[row][column] = number;
        fixedCells[row][column] = fixed;
    }

    public void placeNumber(int row,int column,int number) {
        grid[row][column] = number;
    }

    public boolean isComplete() {

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(grid[i][j]==0)
                    return false;

        return true;
    }

    public void displayBoard() {

        System.out.println("\nCurrent Sudoku:");

        for(int i=0;i<9;i++) {

            if(i%3==0)
                System.out.println("+-------+-------+-------+");

            for(int j=0;j<9;j++) {

                if(j%3==0)
                    System.out.print("| ");

                if(grid[i][j]==0)
                    System.out.print(". ");
                else
                    System.out.print(grid[i][j]+" ");
            }

            System.out.println("|");
        }

        System.out.println("+-------+-------+-------+");
    }
}
