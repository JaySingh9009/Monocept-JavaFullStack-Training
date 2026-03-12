package com.BasicArray;
import java.util.Scanner;

public class FindSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String string = scanner.nextLine();

        System.out.print("Enter substring: ");
        String substring = scanner.nextLine();

        if (substring.length() == 0) {
            System.out.println("Substring is empty. It exists at index 0.");
            return;
        }

        if (string.length() < substring.length()) {
            System.out.println("Substring not found.");
            return;
        }

        int index = string.indexOf(substring);

        if (index != -1) {
            System.out.println("Substring found at index: " + index);
        } else {
            System.out.println("Substring not found.");
        }
    }
}
