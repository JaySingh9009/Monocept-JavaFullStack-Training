package com.TicTacToe.Model;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public String[] getMove() {
        
        return new String[0];
    }
}
