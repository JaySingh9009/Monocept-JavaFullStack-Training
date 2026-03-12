package com.ExampleOfException.Main;

class InvalidBalanceException extends Exception {

    public InvalidBalanceException(String message) {
        super(message);
    }
}

public class BankCustomCheckedException {

	

	    public static void withdraw(int balance, int amount) 
	            throws InvalidBalanceException {

	        if (amount > balance) {
	            throw new InvalidBalanceException("Insufficient Balance");
	        }

	        System.out.println("Withdrawal successful");
	    }

	    public static void main(String[] args) {
	        try {
	            withdraw(1000, 2000);
	        } catch (InvalidBalanceException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	

}
