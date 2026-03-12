package com.crudoperation.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudent {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}