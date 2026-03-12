package com.Exceptionhandling.test;

import java.util.Scanner;

import com.Exceptionhandling.model.MultipleCatch;

public class MainMultipleCatch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MultipleCatch logic = new MultipleCatch();

        boolean exit = false;

        while (!exit) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Access 5th element of array");
            System.out.println("2. Find length of null string");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            try {

                switch (choice) {

                    case 1:
                        logic.accessArrayElement();
                        break;

                    case 2:
                        logic.findLengthOfNullString();
                        break;

                    case 3:
                        exit = true;
                        System.out.println("Program terminated.");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } 
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(" Array index is out of bounds.");
            } 
            catch (NullPointerException e) {
                System.out.println(" Cannot perform operation on null reference.");
            }

        }

        scanner.close();
    }
}
