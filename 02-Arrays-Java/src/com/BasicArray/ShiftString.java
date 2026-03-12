package com.BasicArray;

import java.util.Scanner;

public class ShiftString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String string = scanner.nextLine();

        if (string == null || string.length() == 0) {
            System.out.println("String is empty. Nothing to shift.");
            return;
        }

        System.out.print("Enter shift position: ");
        int position = scanner.nextInt();

        int lengthofstring = string.length();
        position = position % lengthofstring;  // handle large shifts

        String shifted = string.substring(position) + string.substring(0, position);

        System.out.println("Shifted String: " + shifted);
    }


}
