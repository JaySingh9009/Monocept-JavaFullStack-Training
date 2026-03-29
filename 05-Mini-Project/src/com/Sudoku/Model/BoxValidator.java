package com.Sudoku.Model;

public class BoxValidator extends Validator {

    public BoxValidator(SudokuBoard board) {
        super(board);
    }

    @Override
    public boolean validate() {

        int[][] grid = board.getGrid();

        for(int row=0; row<9; row+=3) {

            for(int col=0; col<9; col+=3) {

                boolean[] seen = new boolean[10];

                for(int i=0;i<3;i++) {

                    for(int j=0;j<3;j++) {

                        int num = grid[row+i][col+j];

                        if(num != 0) {

                            if(seen[num])
                                return false;

                            seen[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
