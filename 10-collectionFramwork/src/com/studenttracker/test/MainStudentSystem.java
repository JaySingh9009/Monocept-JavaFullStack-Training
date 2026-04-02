package com.studenttracker.test;

import com.studenttracker.model.*;

public class MainStudentSystem {

    public static void main(String[] args){

        StudentManager manager = new StudentManager();

        System.out.println("====================================");
        System.out.println(" STUDENT PERFORMANCE TRACKER ");
        System.out.println("====================================");

        int choice;

        do{

            System.out.println("\n1 Add Student");
            System.out.println("2 Add Marks");
            System.out.println("3 Show Students");
            System.out.println("4 Show Ranking");
            System.out.println("5 Show Department");
            System.out.println("6 Sort by Name");
            System.out.println("7 Remove Ineligible");
            System.out.println("0 Exit");

            choice = InputValidator.readChoice("Enter choice: ");

            try {

                switch(choice){

                    case 1:

                        int id = InputValidator.readId("Enter ID: ");
                        String name = InputValidator.readString("Enter Name: ");
                        String dept = InputValidator.readString("Enter Department: ");

                        System.out.println("1 UG  2 PG");
                        int type = InputValidator.readChoice("Enter type: ");

                        if(type == 1)
                            manager.addStudent(new UndergraduateStudent(id, name, dept));
                        else if(type == 2)
                            manager.addStudent(new PostgraduateStudent(id, name, dept));
                        else
                            System.out.println("Invalid type selected");

                        break;

                    case 2:

                        int sid = InputValidator.readId("Enter ID: ");
                        String sub = InputValidator.readString("Enter Subject: ");
                        int marks = InputValidator.readMarks("Enter Marks: ");

                        manager.addMarks(sid, sub, marks);
                        break;

                    case 3:
                        manager.showStudents();
                        break;

                    case 4:
                        manager.showRanking();
                        break;

                    case 5:

                        String d = InputValidator.readString("Enter Dept: ");
                        manager.showByDepartment(d);
                        break;

                    case 6:
                        manager.sortByName();
                        break;

                    case 7:
                        manager.removeIneligible();
                        break;

                    case 0:
                        System.out.println("Exiting system...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while(choice != 0);
    }
}