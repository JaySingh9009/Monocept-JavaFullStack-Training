package com.Sudoku.Model;

public class ColumnValidator extends Validator {

    public ColumnValidator(SudokuBoard board) {
        super(board);
    }

    @Override
    public boolean validate() {

        int[][] grid = board.getGrid();

        for(int i=0;i<9;i++) {

            boolean[] seen = new boolean[10];

            for(int j=0;j<9;j++) {

                int num = grid[j][i];

                if(num != 0) {

                    if(seen[num])
                        return false;

                    seen[num] = true;
                }
            }
        }

        return true;
    }
}
