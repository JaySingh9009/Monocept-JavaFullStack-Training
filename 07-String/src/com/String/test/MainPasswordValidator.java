package com.String.test;


import java.util.Scanner;

import com.String.model.PasswordValidator;

public class MainPasswordValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("Password cannot be empty");
            }

            PasswordValidator validator = new PasswordValidator(password);

            System.out.println("Password: " + password);
            System.out.println("Length valid: " + 
                    (validator.isLengthValid() ? "Yes" : "No"));

            System.out.println("Contains uppercase: " + 
                    (validator.hasUpperCase() ? "Yes" : "No"));

            System.out.println("Contains lowercase: " + 
                    (validator.hasLowerCase() ? "Yes" : "No"));

            System.out.println("Contains digit: " + 
                    (validator.hasDigit() ? "Yes" : "No"));

            if (validator.isValidPassword()) {
                System.out.println("Password is VALID");
            } 
            else {
                System.out.println("Password is INVALID");
            }

        } 
        catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        } 
        finally {
            sc.close();
        }
    }
}