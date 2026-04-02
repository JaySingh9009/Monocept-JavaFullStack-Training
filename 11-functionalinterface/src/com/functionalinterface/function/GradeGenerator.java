package com.functionalinterface.function;

import java.util.function.Function;

public class GradeGenerator {
    public static void main(String[] args) {

        Function<Integer, String> grade = marks -> {
            if (marks >= 75) return "A";
            else if (marks >= 50) return "B";
            else return "Fail";
        };

        int[] marksList = {85, 60, 45, 78, 30};

        for (int m : marksList) {
            System.out.println("Marks: " + m + " -> Grade: " + grade.apply(m));
        }
    }
}