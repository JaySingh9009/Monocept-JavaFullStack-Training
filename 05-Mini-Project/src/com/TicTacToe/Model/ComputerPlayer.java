package com.TicTacToe.Model;

import java.util.Random;

public class ComputerPlayer extends Player {
    
    private final Random random;

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
        this.random = new Random();
    }

    @Override
    public String[] getMove() {
       
        int r = random.nextInt(3);
        int c = random.nextInt(3);
        return new String[]{String.valueOf(r), String.valueOf(c)};
    }
}