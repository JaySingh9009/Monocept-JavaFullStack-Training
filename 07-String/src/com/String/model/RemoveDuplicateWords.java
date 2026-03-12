package com.String.model;

public class RemoveDuplicateWords {

    public String removeDuplicates(String sentence) {

        String[] words = sentence.split(" ");
        String result = words[0];

        for (int i = 1; i < words.length; i++) {

            if (!words[i].equals(words[i - 1])) {
                result = result + " " + words[i];
            }
        }

        return result;
    }
}
