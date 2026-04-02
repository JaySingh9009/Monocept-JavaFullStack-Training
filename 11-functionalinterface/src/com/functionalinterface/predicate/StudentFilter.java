package com.functionalinterface.predicate;

import java.util.*;
import java.util.function.Predicate;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); 

            students.add(new Student(name, marks));
        }

        Predicate<Student> isPass = s -> s.marks >= 40;

        System.out.println("Passing students:");
        for (Student s : students) {
            if (isPass.test(s)) {
                System.out.println(s.name + " - " + s.marks);
            }
        }
    }
}