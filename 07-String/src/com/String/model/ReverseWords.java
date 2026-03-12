package com.String.model;


public class ReverseWords {

    public String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {

            String reversed = "";

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed += word.charAt(i);
            }

            result += reversed + " ";
        }

        return result.trim();
    }
}
