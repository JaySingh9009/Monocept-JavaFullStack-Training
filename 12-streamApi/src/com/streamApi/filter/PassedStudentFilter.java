package com.streamApi.filter;

import java.util.*;

public class PassedStudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aman", 75),
                new Student("Rahul", 55),
                new Student("Ankit", 65),
                new Student("Vikas", 40)
        );

        students.stream()
                .filter(s -> s.marks >= 40)
                .forEach(System.out::println);
    }
}
