package com.project.app.controller;

import java.util.List;

import com.project.app.model.Branch;
import com.project.app.model.Course;
import com.project.app.model.Student;
import com.project.app.service.StudentService;

public class AppController {

    private final StudentService service = new StudentService();

    public void start() {
        while (true) {
            showMenu();
            int choice = InputUtil.readInt("Enter choice: ");

            try {
                handleChoice(choice);
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private void showMenu() {
        System.out.println("\n===== STUDENT COURSE & FEE SYSTEM =====");
        System.out.println("1.  Add Student");
        System.out.println("2.  Register for Course");
        System.out.println("3.  View All Students with Branches & Courses");
        System.out.println("4.  Search Student by ID");
        System.out.println("5.  Update Student");
        System.out.println("6.  Update Course Fee");
        System.out.println("7.  Cancel Registration");
        System.out.println("8.  Delete Student");
        System.out.println("9.  High Paying Students Report");
        System.out.println("10. Course-wise Student Count");
        System.out.println("11. Exit");
    }

    private void handleChoice(int choice) throws Exception {
        switch (choice) {
            case 1: addStudent(); break;
            case 2: registerCourse(); break;
            case 3: viewAllStudents(); break;
            case 4: searchStudent(); break;
            case 5: updateStudent(); break;
            case 6: updateFee(); break;
            case 7: cancelRegistration(); break;
            case 8: deleteStudent(); break;
            case 9: highPayingReport(); break;
            case 10: courseStats(); break;
            case 11: 
                System.out.println("Exiting application... Goodbye!"); 
                System.exit(0); 
                break;
            default: 
                System.out.println("[WARNING] Invalid choice. Please try again.");
        }
    }

    private void addStudent() throws Exception {
        int id = InputUtil.readInt("ID: ");
        String name = InputUtil.readString("Name: ");
        int age = InputUtil.readInt("Age: ");
        int branchId = pickBranch();

        service.addStudent(new Student(id, name, age, branchId));
        System.out.println("[SUCCESS] Student added successfully.");
    }

    private void registerCourse() throws Exception {
        int id = InputUtil.readInt("Student ID: ");
        int courseId = pickCourse();
        double fee = InputUtil.readDouble("Fee: ");

        service.registerStudent(id, courseId, fee);
        System.out.println("[SUCCESS] Course registration complete.");
    }

    private void viewAllStudents() throws Exception {
        List<String> students = service.getAllStudentsWithRegistrations();
        if (students.isEmpty()) {
            System.out.println("[INFO] No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private void searchStudent() throws Exception {
        int id = InputUtil.readInt("ID: ");
        Student s = service.getStudentById(id);
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("[INFO] Student not found with ID: " + id);
        }
    }

    private void updateStudent() throws Exception {
        int id = InputUtil.readInt("ID: ");
        String name = InputUtil.readString("New Name: ");
        int branchId = pickBranch();

        service.updateStudent(id, name, branchId);
        System.out.println("[SUCCESS] Student details updated.");
    }

    private void updateFee() throws Exception {
        int id = InputUtil.readInt("Student ID: ");
        int courseId = pickCourse();
        double fee = InputUtil.readDouble("New Fee: ");

        service.updateCourseFee(id, courseId, fee);
        System.out.println("[SUCCESS] Course fee updated.");
    }

    private void cancelRegistration() throws Exception {
        int id = InputUtil.readInt("Student ID: ");
        int courseId = pickCourse();

        service.cancelRegistration(id, courseId);
        System.out.println("[SUCCESS] Registration cancelled.");
    }

    private void deleteStudent() throws Exception {
        int id = InputUtil.readInt("ID: ");
        service.deleteStudent(id);
        System.out.println("[SUCCESS] Student deleted.");
    }

    private void highPayingReport() throws Exception {
        double minFee = InputUtil.readDouble("Enter minimum fee threshold: ");
        List<String> students = service.getPremiumStudents(minFee);
        if (students.isEmpty()) {
            System.out.println("[INFO] No students found paying above " + minFee);
        } else {
            students.forEach(System.out::println);
        }
    }

    private void courseStats() throws Exception {
        System.out.println("\n--- Course-wise Student Count ---");
        service.getCourseStats().forEach((course, count) -> 
            System.out.println(String.format("%-15s : %d students", course, count))
        );
    }

    private int pickBranch() throws Exception {
        List<Branch> branches = service.getAllBranches();
        while (true) {
            System.out.println("\nAvailable Branches:");
            branches.forEach(b -> System.out.println("  " + b));
            
            int input = InputUtil.readInt("Enter Branch ID: ");
            try {
                int id = input;
                if (branches.stream().anyMatch(b -> b.getBranchId() == id)) {
                    return id;
                }
                System.out.println("[WARNING] Invalid branch ID [" + id + "]. Choose from the list.");
            } catch (NumberFormatException e) {
                System.out.println("[WARNING] Please enter a valid numerical ID.");
            }
        }
    }

    private int pickCourse() throws Exception {
        List<Course> courses = service.getAllCourses();
        while (true) {
            System.out.println("\nAvailable Courses:");
            courses.forEach(c -> System.out.println("  " + c));
            
            int input = InputUtil.readInt("Enter Course ID: ");
            try {
                int id = input;
                if (courses.stream().anyMatch(c -> c.getCourseId() == id)) {
                    return id;
                }
                System.out.println("[WARNING] Invalid course ID [" + id + "]. Choose from the list.");
            } catch (NumberFormatException e) {
                System.out.println("[WARNING] Please enter a valid numerical ID.");
            }
        }
    }
}
