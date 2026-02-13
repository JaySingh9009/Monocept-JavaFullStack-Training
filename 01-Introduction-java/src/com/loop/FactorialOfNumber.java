package com.loop;
import java.util.*;

public class FactorialOfNumber {
	public static void main(String[] args) {
//		using for loop
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a number");
		int number=scanner.nextInt();
		int factorial=1;
		for(int i=1;i<=number;i++) {
			factorial*=i;
		}
		System.out.println("Factorial of " + number +" is " + factorial);
		
//		using while loop
		int newfactorial=1;
		int i=1;
		while(i<=number) {
			newfactorial*=i;
			i++;
		}
		System.out.println("Factorial of " + number +" is " + newfactorial);
	}
}
