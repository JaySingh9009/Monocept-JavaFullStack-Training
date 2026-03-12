package com.ExampleOfException.Main;

public class ThrowExample {

    public static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Age must be 18 or above");
        }
        System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        validateAge(15);
    }
}