package com.functionalinterface.function;

import java.util.function.Function;

public class StringLength {
    public static void main(String[] args) {

        Function<String, Integer> getLength = s -> s.length();

        String[] names = {"Aman", "Riya", "Karan"};

        for (String name : names) {
            System.out.println(name + " -> " + getLength.apply(name));
        }
    }
}
