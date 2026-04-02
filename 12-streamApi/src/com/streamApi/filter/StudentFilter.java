package com.streamApi.filter;
import java.util.*;


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


public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Aman", 75),
                new Student("Rahul", 55),
                new Student("Ankit", 65),
                new Student("Vikas", 40)
        );

        students.stream()
                .filter(s -> s.marks >= 60)
                .forEach(System.out::println);
    }
}
