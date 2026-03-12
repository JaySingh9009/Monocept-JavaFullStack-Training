package com.String.test;


import java.util.Scanner;

import com.String.model.SentenceFormatter;

public class MainSentenceFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Sentence: ");
            String sentence = sc.nextLine();

            if (sentence == null || sentence.trim().isEmpty()) {
                throw new IllegalArgumentException("Sentence cannot be empty");
            }

            SentenceFormatter formatter = new SentenceFormatter(sentence);

            System.out.println("Formatted Sentence: " + 
                    formatter.getFormattedSentence());

            System.out.println("Total words: " + 
                    formatter.getWordCount());

            System.out.println("First word: " + 
                    formatter.getFirstWord());

            System.out.println("Last word: " + 
                    formatter.getLastWord());

        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        finally {
            sc.close();
        }
    }
}