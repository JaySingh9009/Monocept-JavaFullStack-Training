package com.crudoperation.model;

import java.io.*;

public class DeleteStudent {

    public static void main(String[] args) throws Exception {

        File file = new File("students.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String newData = "";

        while ((line = br.readLine()) != null) {

            if (!line.contains("Mike")) {
                newData += line + "\n";
            }
        }

        br.close();

        FileWriter fw = new FileWriter(file);
        fw.write(newData);
        fw.close();

        System.out.println("Record Deleted");
    }
}
