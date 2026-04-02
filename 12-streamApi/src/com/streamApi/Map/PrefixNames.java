package com.streamApi.Map;

import java.util.*;

public class PrefixNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aman", "Priya", "Rahul");

        names.stream()
                .map(name -> name.equals("Priya") ? "Ms. " + name : "Mr. " + name)
                .forEach(System.out::println);
    }
}
