package com.trywithresourse.main;

import java.util.Scanner;

public class DemoTryWithResourse {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter any Integer: ");
		    int x = sc.nextInt();
		    System.out.println("value : " + x);

		}
		catch(Exception e){

		    System.out.println(e);

		}
		finally{

		    System.out.println("Program finished");

		}
	}

}
