package com.TicTacToe.Main;

import com.TicTacToe.Model.TicTacToeFacade;

public class Main {
    public static void main(String[] args) {
        TicTacToeFacade facade = new TicTacToeFacade();
        facade.startGame();
    }
}