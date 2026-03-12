package com.Exceptionhandling.model;

public class NestedTryCatchExample {
	public void performOperations() {

	        try {
	            System.out.println("Outer try block started.");

	            try {
	                System.out.println("Inner try block started.");

	                int[] arr = new int[2];
	                System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException

	            } 
	            catch (ArrayIndexOutOfBoundsException e) {
	                System.out.println("Inner Catch: Array index out of bounds.");
	            }

	            // After inner handled, now trigger ArithmeticException
	            int result = 10 / 0;

	        } 
	        catch (ArithmeticException e) {
	            System.out.println("Outer Catch: Cannot divide by zero.");
	        }

	        System.out.println("Program continues after exception handling.");
	    }
	
}
