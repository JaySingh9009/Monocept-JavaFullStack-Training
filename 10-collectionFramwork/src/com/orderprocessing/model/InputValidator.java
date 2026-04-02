package com.orderprocessing.model;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner sc = new Scanner(System.in);

    public static int readOrderId(String msg){

        while(true){
            try {
                System.out.print(msg);

                String input = sc.nextLine().trim();

                if(!input.matches("\\d+"))
                    throw new NumberFormatException("Order ID must be numeric");

                int id = Integer.parseInt(input);

                if(id < 1000 || id > 9999)
                    throw new IllegalArgumentException("Order ID must be between 1000-9999");

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


    public static double readAmount(String msg){

        while(true){
            try {
                System.out.print(msg);

                String input = sc.nextLine().trim();

                double val = Double.parseDouble(input); // can throw NumberFormatException

                if(val <= 0)
                    throw new IllegalArgumentException("Amount must be greater than 0");

                return val;
            }
            catch (NumberFormatException e){
                System.out.println("ERROR: Amount must be a valid number");
            }
            catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }


    public static String readName(String msg){

        while(true){
            try {
                System.out.print(msg);

                String name = sc.nextLine().trim();

                name = name.replaceAll("\\s+"," ");

                if(name.isEmpty())
                    throw new IllegalArgumentException("Name cannot be empty");

                if(!name.matches("[a-zA-Z ]+"))
                    throw new IllegalArgumentException("Only alphabets allowed");

                return name;
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