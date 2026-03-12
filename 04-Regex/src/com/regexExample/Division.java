package com.regexExample;


public class Division {

    private int a;
    private int b;

    public Division(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int div() {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0; 
        }
        return a / b;  
    }
}