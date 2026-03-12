package com.Exceptionhandling.test;

import java.util.Scanner;

import com.Exceptionhandling.model.InvalidPasswordException;
import com.Exceptionhandling.model.PasswordValidator;

public class MainCustomException {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PasswordValidator validator = new PasswordValidator();

        try {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            validator.checkPassword(password);

        } 
        catch (InvalidPasswordException e) {
            System.out.println("Password Error: " + e.getMessage());
        } 
        finally {
            System.out.println("Password validation process completed.");
            scanner.close();
        }
    }
}
