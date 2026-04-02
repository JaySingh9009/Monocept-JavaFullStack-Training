package com.streamApi.filter;

import java.util.*;

public class NonEmptyStringFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "", " ", "Stream", "API");

        words.stream()
                .filter(str -> !str.trim().isEmpty())
                .forEach(System.out::println);
    }
}