package com.Exceptionhandling.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Exceptionhandling.model.MarksValidator;

public class MainThrowExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MarksValidator validator = new MarksValidator();

        try {
            System.out.print("Enter marks: ");
            int marks = scanner.nextInt();

            validator.validateMarks(marks);

        } 
        catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } 
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric value only.");
        } 
        finally {
            System.out.println("Validation process completed.");
            scanner.close();
        }
    }
}
