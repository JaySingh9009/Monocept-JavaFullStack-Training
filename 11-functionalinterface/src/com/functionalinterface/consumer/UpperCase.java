package com.functionalinterface.consumer;

import java.util.function.Consumer;

public class UpperCase {
    public static void main(String[] args) {

        Consumer<String> toUpper = s -> System.out.println(s.toUpperCase());

        toUpper.accept("java");
        toUpper.accept("functional interface");
    }
}