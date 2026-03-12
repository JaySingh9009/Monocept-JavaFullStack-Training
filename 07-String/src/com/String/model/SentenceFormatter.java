package com.String.model;

public class SentenceFormatter {

    private String sentence;
    private String formattedSentence;
    private String[] words;

    public SentenceFormatter(String sentence) {

        sentence = sentence.trim();

        sentence = sentence.toLowerCase();

        sentence = sentence.replace("fun", "interesting");

        sentence = sentence.substring(0,1).toUpperCase() + sentence.substring(1);

        this.formattedSentence = sentence;

        words = formattedSentence.split(" ");
    }

    public String getFormattedSentence() {
        return formattedSentence;
    }

    public int getWordCount() {
        return words.length;
    }

    public String getFirstWord() {
        return words[0];
    }

    public String getLastWord() {
        return words[words.length - 1];
    }
}