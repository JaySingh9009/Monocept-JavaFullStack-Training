package com.BasicArray;

import java.util.Arrays;
import java.util.Scanner;

public class PeakElementsOfArray {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the valid size of Array: ");
		int size=scanner.nextInt();
		if(size>0) {
			int[] array=new int[size];
			System.out.println("Enter array elements :");
			for(int i=0;i<size;i++) {
				array[i]=scanner.nextInt();
			}
			int[] peakelements=new int[size];
			int indexofpeak=0;
			if(array[0]>array[1]) peakelements[indexofpeak++]=array[0];
			
			
			
			for(int i=1;i<size-1;i++) {
				if(array[i]>array[i+1] && array[i]>array[i-1]) {
					peakelements[indexofpeak]=array[i];
					indexofpeak++;
				}
			}
			if(array[size-1]>array[size-2]) peakelements[indexofpeak]=array[size-1];
			System.out.println("peak elements of array is: ");
			for(int i=0;i<=indexofpeak;i++) {
				System.out.println(peakelements[i]);
				
			}
			
		}else {
			System.out.println("Enter a valid positive size");
		}
		
	}

}
