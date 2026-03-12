package com.BasicArray;
import java.util.Scanner;

public class MaxConsecutiveones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Invalid array size.");
            return;
        }

        int[] array = new int[size];
        System.out.println("Enter binary elements (0 or 1):");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            if (array[i] != 0 && array[i] != 1) {
                System.out.println("Invalid input. Only 0 and 1 allowed.");
                return;
            }
        }

        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        System.out.println("Maximum consecutive 1s: " + maxCount);
    }
}
