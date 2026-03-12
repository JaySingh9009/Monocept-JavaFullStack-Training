package com.ExampleOfException.Main;

public class DemoTryCatchFinally {

	    public static void main(String[] args) {

	        try {
	           
				int x = 10 / 0;
	        } catch (ArithmeticException e) {
	            System.out.println("Handled divide by zero");
	        } finally {
	            System.out.println("Cleanup done");
	        }
	    }
	
}
