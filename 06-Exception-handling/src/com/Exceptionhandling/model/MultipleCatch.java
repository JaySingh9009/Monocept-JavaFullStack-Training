package com.Exceptionhandling.model;

public class MultipleCatch {
	 public void accessArrayElement() {
	        String[] arr = new String[2];

	        System.out.println("Accessing 5th element: " + arr[4]);
	    }

	    public void findLengthOfNullString() {
	        String str = null;

	        System.out.println("Length of string: " + str.length());
	    }
	

}
