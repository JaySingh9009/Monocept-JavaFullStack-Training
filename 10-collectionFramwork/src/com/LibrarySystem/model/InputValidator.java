package com.LibrarySystem.model;

import java.util.Scanner;

import javax.activity.InvalidActivityException;

public class InputValidator {

    private static final Scanner sc = new Scanner(System.in);

    public static int readChoice(String message) {

        while (true) {
            try {
                System.out.print(message);

                String input = sc.nextLine().trim();

                if (!input.matches("\\d+"))
                    throw new Exception("Choice must be a number");

                int choice = Integer.parseInt(input);

                if (choice < 0 || choice > 6)
                    throw new Exception("Choice must be between 0 and 6");

                return choice;
            }
            
            catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }


    public static int readBookId(String message) {

        while (true) {
            try {
                System.out.print(message);

                String input = sc.nextLine().trim();

                if (!input.matches("\\d+"))
                    throw new Exception("Book ID must be numeric");

                int id = Integer.parseInt(input);

                if (id < 1000 || id > 9999)
                    throw new Exception("Book ID must be between 1000 and 9999");

                return id;
            }
            
            catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }


    public static String readString(String message) {

        while (true) {
            try {
                System.out.print(message);

                String value = sc.nextLine().trim();

                value = value.replaceAll("\\s+", " ");

                if (value.isEmpty())
                    throw new Exception("Input cannot be empty");

                if (!value.matches("[a-zA-Z ]+"))
                    throw new Exception("Only alphabets allowed");

                return value;
            }
            
            catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }
    }
}