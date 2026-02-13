package com.loop;
import java.util.*;

public class PrintOddNumber {
	public static void main(String[] args) {
//		Printing from 1 to 10 by using for loop;
		System.out.println("Using for loop finding odd number till 100");
		for(int i=1;i<100;i++) {
			if(i%2!=0)
			System.out.println(i);
		}
		
//		Printint 1 to 10 by while loop;
		System.out.println("Using for while finding odd number till 100");
		int i=1;
		while(i<=100) {
			if(i%2!=0)
			System.out.println(i);
			i++;
		}
		
	}

}
