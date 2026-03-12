package com.TicTacToe.Model;

public class Board {

    private char[] board;

    public Board() {
        board = new char[9];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);  
        }
    }

    public void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    public boolean placeMove(int position, char symbol) {

        if (position < 1 || position > 9)
            return false;

        if (board[position - 1] != 'X' && board[position - 1] != 'O') {
            board[position - 1] = symbol;
            return true;
        }

        return false;
    }

    public boolean checkWin(char s) {

        int[][] winPatterns = {
                {0,1,2}, {3,4,5}, {6,7,8},
                {0,3,6}, {1,4,7}, {2,5,8},
                {0,4,8}, {2,4,6}
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] == s &&
                board[pattern[1]] == s &&
                board[pattern[2]] == s)
                return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O')
                return false;
        }
        return true;
    }
}