package com.array.model;

public class Array {

    public int[] reverseArray(int[] arr) {

       
        if (arr == null) {
            return null;
        }

        int n = arr.length;
        int[] reversed = new int[n];

        for (int i = 0; i < n; i++) {
            reversed[i] = arr[n - 1 - i];
        }

        return reversed;
    }
}
