package com.functionalinterface.consumer;

import java.util.*;
import java.util.function.Consumer;

public class ListPrinter {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Apple", "Banana", "Mango");

        Consumer<List<String>> printList = l -> {
            for (String item : l) {
                System.out.println(item);
            }
        };

        printList.accept(list);
    }
}
