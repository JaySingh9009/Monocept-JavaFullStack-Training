package com.crudoperation.model;

import java.io.*;

public class StudentService {

    File file = new File("students.txt");

    public void addStudent(int id, String name) throws Exception {

        FileWriter fw = new FileWriter(file, true);
        fw.write(id + " " + name + "\n");
        fw.close();

        System.out.println("Student Added");
    }

    public void viewStudents() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        System.out.println("\nStudent Records:");

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public void updateStudent(int id, String newName) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder newData = new StringBuilder();

        while ((line = br.readLine()) != null) {

            String[] data = line.split(" ");

            if (Integer.parseInt(data[0]) == id) {
                line = id + " " + newName;
            }

            newData.append(line).append("\n");
        }

        br.close();

        FileWriter fw = new FileWriter(file);
        fw.write(newData.toString());
        fw.close();

        System.out.println("Student Updated");
    }

    public void deleteStudent(int id) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder newData = new StringBuilder();

        while ((line = br.readLine()) != null) {

            String[] data = line.split(" ");

            if (Integer.parseInt(data[0]) != id) {
                newData.append(line).append("\n");
            }
        }

        br.close();

        FileWriter fw = new FileWriter(file);
        fw.write(newData.toString());
        fw.close();

        System.out.println("Student Deleted");
    }
}