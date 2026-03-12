package com.regexExample;
import java.util.Scanner;

public class MobileNumberValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Mobile Number: ");
        String mobile = scanner.nextLine().trim();

        if (mobile.isEmpty()) {
            System.out.println("Mobile number cannot be empty.");
            return;
        }

        String regex = "^[6-9][0-9]{9}$";

        if (mobile.matches(regex)) {
            System.out.println("Valid Mobile Number ");
        } else {
            System.out.println("Invalid Mobile Number ");
        }

        scanner.close();
    }
}