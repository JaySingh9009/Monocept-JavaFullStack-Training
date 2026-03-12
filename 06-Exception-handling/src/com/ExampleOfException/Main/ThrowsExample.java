package com.ExampleOfException.Main;

import java.io.*;

public class ThrowsExample {

    public static void readFile() throws IOException {
        FileReader fr = new FileReader("abc.txt");
        System.out.println("File opened successfully");
        fr.close();
    }

    public static void main(String[] args) throws IOException {
        readFile();
    }
}