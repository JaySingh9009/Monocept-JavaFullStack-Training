package com.Arrayofobject.test;
import java.util.Scanner;
import com.Arrayofobject.model.*;

public class MainCourse {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of courses you want to add: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Number of courses must be an integer.");
            return;
        }

        int numberOfCourses = scanner.nextInt();
        if (numberOfCourses <= 0) {
            System.out.println("Number of courses must be greater than 0.");
            return;
        }

        Course[] courses = new Course[numberOfCourses];
        int[] usedIds = new int[numberOfCourses];   
        int usedCount = 0;

        for (int i = 0; i < numberOfCourses; i++) {

            System.out.println("\nEnter details for Course " + (i + 1));
            System.out.println("1. Regular Course");
            System.out.println("2. Online Course");
            System.out.print("Choose course type: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Must be a number.");
                return;
            }
            int choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid course type selected.");
                return;
            }

            System.out.print("Enter Course ID (integer): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Course ID must be an integer.");
                return;
            }
            int courseId = scanner.nextInt();

            for (int k = 0; k < usedCount; k++) {
                if (usedIds[k] == courseId) {
                    System.out.println("Duplicate Course ID not allowed.");
                    return;
                }
            }
            usedIds[usedCount++] = courseId;

            scanner.nextLine(); 

            System.out.print("Enter Course Name: ");
            String courseName = scanner.nextLine().trim();
            if (courseName.isEmpty()) {
                System.out.println("Course name cannot be empty.");
                return;
            }

            System.out.print("Enter Base Fee: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Base fee must be a valid number.");
                return;
            }
            double baseFee = scanner.nextDouble();
            if (baseFee <= 0) {
                System.out.println("Base fee must be greater than 0.");
                return;
            }
            switch (choice) {

                case 1:
                    System.out.print("Enter Lab Fee: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Lab fee must be a valid number.");
                        return;
                    }
                    double labFee = scanner.nextDouble();
                    if (labFee < 0) {
                        System.out.println("Lab fee cannot be negative.");
                        return;
                    }

                    courses[i] = new RegularCourse(courseId, courseName, baseFee, labFee);
                    break;

                case 2:
                    System.out.print("Enter Platform Fee: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Platform fee must be a valid number.");
                        return;
                    }
                    double platformFee = scanner.nextDouble();
                    if (platformFee < 0) {
                        System.out.println("Platform fee cannot be negative.");
                        return;
                    }

                    courses[i] = new OnlineCourse(courseId, courseName, baseFee, platformFee);
                    break;
            }

            scanner.nextLine();
        }

        System.out.println("\n---- Final Course Fees ----");
        for (Course c : courses) {
            System.out.println(
                "Course ID: " + c.getCourseId() +
                ", Name: " + c.getCourseName() +
                ", Final Fee: ₹" + c.calculateFee()
            );
        }

        System.out.println("\nTotal Courses Created: " + Course.getTotalCourses());
    }
}