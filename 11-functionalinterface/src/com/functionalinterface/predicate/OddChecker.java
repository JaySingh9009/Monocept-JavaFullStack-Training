package com.functionalinterface.predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class OddChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter range: ");
        int n = sc.nextInt();

        Predicate<Integer> isOdd = x -> x % 2 != 0;

        System.out.println("Odd numbers are:");
        for (int i = 1; i <= n; i++) {
            if (isOdd.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}