package com.Exceptionhandling.test;
import java.util.Scanner;
import com.Exceptionhandling.model.NestedTryCatchExample;

public class MainNestedTryCatch {
	public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);
	        NestedTryCatchExample logic = new NestedTryCatchExample();

	        System.out.println("Press Enter to trigger nested exceptions...");
	        scanner.nextLine();

	        logic.performOperations();

	        scanner.close();
	    }
	

}
