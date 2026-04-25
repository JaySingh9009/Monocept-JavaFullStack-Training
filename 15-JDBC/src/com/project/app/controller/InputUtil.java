package com.project.app.controller;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter integer: ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    public static double readDouble(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter number: ");
            scanner.next();
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }

    public static String readString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = scanner.nextLine().trim();
            input = input.replaceAll("\\s+", " ");
            if (input.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                return input;
            }

            System.out.println("Invalid input. Only alphabets allowed, no numbers or special characters.");
        }
    }}

