package com.String.test;
import java.util.Scanner;

import com.String.model.WordFrequencyCounter;

public class MainWordFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Sentence: ");
            String sentence = sc.nextLine();

            if (sentence == null || sentence.trim().isEmpty()) {
                throw new IllegalArgumentException("Sentence cannot be empty");
            }

            WordFrequencyCounter counter = new WordFrequencyCounter(sentence);

            counter.printWordFrequency();

        }

        catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }

        finally {
            sc.close();
        }
    }
}
