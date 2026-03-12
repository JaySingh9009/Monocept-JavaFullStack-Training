package com.String.test;
import java.util.Scanner;

import com.String.model.FirstNonRepeating;

public class MainFirstNonRepeating {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter string: ");
            String input = sc.nextLine();

            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }

            FirstNonRepeating obj = new FirstNonRepeating();

            char result = obj.findFirst(input);

            if (result == '_')
                System.out.println("No non-repeating character found");
            else
                System.out.println("First non-repeating character: " + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}