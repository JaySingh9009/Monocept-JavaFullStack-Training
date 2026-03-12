package com.BasicArray; 
import java.util.Scanner;

public class DynamicTwoDimensionalArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        if (rows <= 0) {
            System.out.println("Number of rows must be positive.");
            return;
        }

        int[][] array = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter number of columns for row " + i + " ");
            int columns = scanner.nextInt();

            if (columns <= 0) {
                System.out.println("Number of columns must be positive.");
                return;
            }

            array[i] = new int[columns];

            System.out.println("Enter " + columns + " elements for row " + i + " ");
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Dynamic 2D Array is:");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
