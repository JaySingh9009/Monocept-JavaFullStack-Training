package com.ExampleOfException.Main;

import java.io.*;

public class CheckedPropagation {

    static void readFile() throws IOException {
        FileReader fr = new FileReader("abc.txt");
    }

    static void callRead() throws IOException {
        readFile();
    }

    public static void main(String[] args) {
        try {
            callRead();
        } catch (IOException e) {
            System.out.println("File not found, handled in main()");
        }
    }
}
