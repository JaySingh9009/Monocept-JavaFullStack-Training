package com.crudoperation.model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class UpdateStudent {

    public static void main(String[] args) throws Exception {

        File file = new File("students.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        StringBuilder newData = new StringBuilder();

        while ((line = br.readLine()) != null) {

            if (line.startsWith("3 ")) {   
                line = "1 Mike";
            }

            newData.append(line).append("\n");
        }

        br.close();

        FileWriter fw = new FileWriter(file);
        fw.write(newData.toString());
        fw.close();

        System.out.println("Record Updated");
    }
}