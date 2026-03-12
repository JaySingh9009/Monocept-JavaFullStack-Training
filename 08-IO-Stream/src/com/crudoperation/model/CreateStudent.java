package com.crudoperation.model;

import java.io.FileWriter;
import java.io.IOException;

public class CreateStudent {

    public static void main(String[] args) {

        try {
            FileWriter fw = new FileWriter("students.txt", true); 
            fw.write("3 Bob\n");
            fw.close();

            System.out.println("Student Added");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}