package com.ExampleOfException.Main;

public class UncheckedPropagation {

	    static void m3() {
	        int x = 10 / 0;  
	    }

	    static void m2() {
	        m3();
	    }

	    static void m1() {
	        m2();
	    }

	    public static void main(String[] args) {
	        try {
	            m1();
	        } catch (ArithmeticException e) {
	            System.out.println("Exception handled in main()");
	        }
	    }
	

}
