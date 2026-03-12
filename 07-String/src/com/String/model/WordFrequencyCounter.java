package com.String.model;

public class WordFrequencyCounter {

    private String sentence;
    private String[] words;

    public WordFrequencyCounter(String sentence) {

        this.sentence = sentence.toLowerCase();

        words = this.sentence.split(" ");
    }

    public void printWordFrequency() {

        boolean[] visited = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {

            if (visited[i])
                continue;

            int count = 1;

            for (int j = i + 1; j < words.length; j++) {

                if (words[i].equals(words[j])) {

                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(words[i] + " : " + count);
        }
    }
}