package com.streamApi.filter;

import java.util.*;

public class NameFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aman", "Rahul", "Ankit", "Vikas", "Ajay");

        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }
}