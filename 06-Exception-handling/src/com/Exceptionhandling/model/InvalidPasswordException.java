package com.Exceptionhandling.model;
public class InvalidPasswordException extends Exception {



	public InvalidPasswordException(String message) {
        super(message);
    }
}