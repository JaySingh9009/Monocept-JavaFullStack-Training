package com.Sudoku.Model;

public class SudokuValidator {

    private SudokuBoard board;

    public SudokuValidator(SudokuBoard board) {
        this.board = board;
    }

    public boolean validateSudoku() {

        Validator row = new RowValidator(board);
        Validator col = new ColumnValidator(board);
        Validator box = new BoxValidator(board);

        return row.validate() && col.validate() && box.validate();
    }
}
