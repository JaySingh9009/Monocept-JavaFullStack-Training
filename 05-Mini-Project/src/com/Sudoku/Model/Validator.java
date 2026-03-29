package com.Sudoku.Model;

public abstract class Validator {

    protected SudokuBoard board;

    public Validator(SudokuBoard board) {
        this.board = board;
    }

    public abstract boolean validate();

}