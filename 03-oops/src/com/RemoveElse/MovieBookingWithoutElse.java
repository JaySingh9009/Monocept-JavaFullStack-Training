package com.RemoveElse;

import java.util.Scanner;

public class MovieBookingWithoutElse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Is seat available? (true/false): ");
        boolean seatAvailable = scanner.nextBoolean();

        if (!seatAvailable) {
            System.out.println("No seats available.");
            scanner.close();
            return;
        }

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 18) {
            System.out.println("You must be 18+ ");
            scanner.close();
            return;
        }

        System.out.println("Booking confirmed! ");
        scanner.close();
    }
}
