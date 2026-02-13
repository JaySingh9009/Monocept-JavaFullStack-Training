package com.practice;
import java.util.*;

public class CheckTypeOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int integer;
        System.out.println("Enter the Integer value");
        integer = scanner.nextInt();

        if (integer > 0) {
            System.out.println(integer +" is Positive integer");
        } else if (integer < 0) {
            System.out.println(integer + " is Negative integer");
        } else {
            System.out.println(integer + " is Zero integer");
        }
    }
}
