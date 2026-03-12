package com.ExampleOfException.Main;

public class DemoThrowable {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (Throwable t) {
            System.out.println("Caught using Throwable: " + t);
        }
    }
}