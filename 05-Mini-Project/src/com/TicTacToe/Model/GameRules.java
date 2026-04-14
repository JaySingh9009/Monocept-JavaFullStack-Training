package com.TicTacToe.Model;

public class GameRules {
    
    public GameStatus checkStatus(Board board, Player lastPlayer) {
        if (checkWin(board, lastPlayer.getSymbol())) {
            return GameStatus.WIN;
        }
        if (board.isFull()) {
            return GameStatus.DRAW;
        }
        return GameStatus.ONGOING;
    }

    private boolean checkWin(Board board, char symbol) {
        int size = board.getSize();

       
        for (int i = 0; i < size; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) != symbol) rowWin = false;
                if (board.getCell(j, i) != symbol) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

     
        boolean diagonal1Win = true;
        boolean diagonal2Win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i) != symbol) diagonal1Win = false;
            if (board.getCell(i, size - 1 - i) != symbol) diagonal2Win = false;
        }
        
        return diagonal1Win || diagonal2Win;
    }
}
