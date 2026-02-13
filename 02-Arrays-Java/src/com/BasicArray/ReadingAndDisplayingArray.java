package com.BasicArray;
import java.util.*;

public class ReadingAndDisplayingArray {
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
			System.out.println("Displaying array elements: ");
			for(int i=0;i<size;i++) {
				System.out.println(array[i]);
			}
		}else {
			System.out.println("Enter a valid positive size");
		}
	}
	

}
