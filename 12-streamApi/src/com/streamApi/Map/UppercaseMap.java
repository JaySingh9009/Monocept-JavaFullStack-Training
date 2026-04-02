package com.streamApi.Map;

import java.util.*;

public class UppercaseMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("aman", "rahul", "ankit");

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}