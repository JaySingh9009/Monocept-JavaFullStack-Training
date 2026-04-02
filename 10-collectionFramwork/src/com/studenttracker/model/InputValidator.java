package com.studenttracker.model;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner sc = new Scanner(System.in);

    public static int readId(String msg){

        while(true){
            try {
                System.out.print(msg);

                String input = sc.nextLine().trim();

                if(!input.matches("\\d{4}"))
                    throw new NumberFormatException("ID must be a 4-digit number");

                int id = Integer.parseInt(input);

                if(id < 1000 || id > 9999)
                    throw new IllegalArgumentException("ID must be between 1000-9999");

                return id;
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: " + e.getMessage());
            }
            catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }


    public static int readMarks(String msg){

        while(true){
            try {
                System.out.print(msg);

                String input = sc.nextLine().trim();

                int marks = Integer.parseInt(input);

                if(marks < 0 || marks > 100)
                    throw new IllegalArgumentException("Marks must be between 0-100");

                return marks;
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: Marks must be a valid number");
            }
            catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }


    public static String readString(String msg){

        while(true){
            try {
                System.out.print(msg);

                String val = sc.nextLine().trim();

                val = val.replaceAll("\\s+"," ");

                if(val.isEmpty())
                    throw new IllegalArgumentException("Input cannot be empty");

                if(!val.matches("[a-zA-Z ]+"))
                    throw new IllegalArgumentException("Only alphabets allowed");

                return val;
            }
            catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }


    public static int readChoice(String msg){

        while(true){
            try {
                System.out.print(msg);

                String input = sc.nextLine().trim();

                if(!input.matches("\\d+"))
                    throw new NumberFormatException("Choice must be numeric");

                return Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}