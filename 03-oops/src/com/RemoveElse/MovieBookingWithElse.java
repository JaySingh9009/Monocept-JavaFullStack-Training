package com.RemoveElse;

import java.util.Scanner;

public class MovieBookingWithElse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Is seat available? (true/false): ");
        boolean seatAvailable = scanner.nextBoolean();

        if (seatAvailable) {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            if (age >= 18) {
                System.out.print("Booking done ! ");
               
            } else {
                System.out.println("You must be 18+ ");
            }
        } else {
            System.out.println("No seats available.");
        }

        scanner.close();
    }
}
