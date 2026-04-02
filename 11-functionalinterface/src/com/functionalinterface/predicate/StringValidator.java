package com.functionalinterface.predicate;

import java.util.*;
import java.util.function.Predicate;

public class StringValidator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string: ");
            list.add(sc.nextLine());
        }

        Predicate<String> valid = s -> s != null && !s.trim().isEmpty();

        System.out.println("Valid strings are:");
        for (String s : list) {
            if (valid.test(s)) {
                System.out.println(s);
            }
        }
    }
}