package com.InstituteSystem.test;

import java.util.Scanner;
import com.InstituteSystem.model.*;

public class MainInstituteSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {

            System.out.println("\nEnter details for student " + (i+1));

            int id;
            boolean duplicate;

            do {
                duplicate = false;

                System.out.print("Student ID: ");
                id = sc.nextInt();
                sc.nextLine();

                for(int j = 0; j < i; j++) {
                    if(students[j].getStudentId() == id) {
                        System.out.println("Duplicate ID not allowed");
                        duplicate = true;
                    }
                }

            } while(duplicate);

            String name;

            do {
                System.out.print("Name: ");
                name = sc.nextLine().trim();

                if(name.isEmpty()) {
                    System.out.println("Name cannot be empty");
                }
                else if(!name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$")) {
                    System.out.println("Name must contain only letters and single spaces");
                }

            } while(name.isEmpty() || !name.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"));


            String course;

            do {
                System.out.print("Course: ");
                course = sc.nextLine().trim();

                if(course.isEmpty()) {
                    System.out.println("Course cannot be empty");
                }
                else if(!course.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$")) {
                    System.out.println("Course must contain only letters and single spaces");
                }

            } while(course.isEmpty() || !course.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"));


            System.out.println("1. Regular Student");
            System.out.println("2. Scholarship Student");

            int type = sc.nextInt();

            if(type == 1) {

                double attendance;

          
                do {
                    System.out.print("Attendance (0-100): ");
                    attendance = sc.nextDouble();

                    if(attendance < 0 || attendance > 100) {
                        System.out.println("Invalid attendance");
                    }

                } while(attendance < 0 || attendance > 100);

                students[i] = new RegularStudent(id, name, course, attendance);
            }

            else {

                System.out.print("Scholarship Amount: ");
                double scholarship = sc.nextDouble();

                students[i] = new ScholarshipStudent(id, name, course, scholarship);
            }
        }

        int choice;

        do {

            System.out.println("\n------ MENU ------");
            System.out.println("1. Display Students");
            System.out.println("2. Update Course");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    for(Student s : students) {
                        s.displayProfile();
                    }
                    break;

                case 2:

                    System.out.print("Enter Student ID to update course: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for(Student s : students) {

                        if(s.getStudentId() == searchId) {

                            String newCourse;
                            do {
                                System.out.print("Enter new course: ");
                                newCourse = sc.nextLine().trim();

                                if(newCourse.isEmpty()) {
                                    System.out.println("Course cannot be empty");
                                }
                                else if(!newCourse.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$")) {
                                    System.out.println("Course must contain only letters and single spaces");
                                }

                            } while(newCourse.isEmpty() || !newCourse.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$"));

                            s.setCourse(newCourse);

                            System.out.println("Course updated successfully");
                            found = true;
                        }
                    }

                    if(!found) {
                        System.out.println("Student not found");
                    }

                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");

            }

        } while(choice != 3);

        sc.close();
    }
}