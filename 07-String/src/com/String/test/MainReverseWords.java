package com.String.test;


import java.util.Scanner;
import com.String.model.ReverseWords;

public class MainReverseWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter sentence: ");
            String input = sc.nextLine();

            if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("Sentence cannot be empty");
            }

            ReverseWords obj = new ReverseWords();

            System.out.println("Output: " + obj.reverseEachWord(input));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
