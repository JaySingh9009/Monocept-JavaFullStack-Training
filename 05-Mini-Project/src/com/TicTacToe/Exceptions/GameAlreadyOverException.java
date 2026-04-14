package com.TicTacToe.Exceptions;

public class GameAlreadyOverException extends Exception {
    public GameAlreadyOverException(String message) {
        super(message);
    }
}
