package com.regexExample;

import java.util.Scanner;

public class EmailValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email address: ");
        String email = scanner.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email.matches(regex)) {
            System.out.println("Valid Email Address ");
        } else {
            System.out.println("Invalid Email Address ");
        }

        scanner.close();
    }
}
