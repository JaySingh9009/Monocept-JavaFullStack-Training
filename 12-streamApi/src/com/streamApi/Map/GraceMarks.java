package com.streamApi.Map;
import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " : " + marks;
    }
}


public class GraceMarks {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aman", 30),
                new Student("Rahul", 50),
                new Student("Ankit", 20)
        );

        List<Student> updated = students.stream()
                .map(s -> {
                    if (s.marks < 35) {
                        return new Student(s.name, s.marks + 5);
                    }
                    return s;
                })
                .collect(Collectors.toList());

        updated.forEach(System.out::println);
    }
}