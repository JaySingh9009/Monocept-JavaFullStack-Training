package com.ExampleOfException.Main;

class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class VotingCustomUncheckedException {



	    public static void checkAge(int age) {

	        if (age < 18) {
	            throw new InvalidAgeException("Not eligible to vote");
	        }

	        System.out.println("Eligible to vote");
	    }

	    public static void main(String[] args) {
	        checkAge(15);
	    }
	
}
