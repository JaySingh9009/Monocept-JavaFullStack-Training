package com.String.test;
import java.util.Scanner;
import com.String.model.RemoveDuplicateWords;

public class MainRemoveDuplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter sentence: ");
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                throw new IllegalArgumentException("Sentence cannot be empty");
            }

            RemoveDuplicateWords obj = new RemoveDuplicateWords();

            System.out.println(obj.removeDuplicates(input));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
