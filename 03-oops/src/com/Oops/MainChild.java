package com.Oops;

 class Child extends Parent{
	
	Child(){
		super();
		System.out.println("Child");
	}
	Child(int x){
		this();
		System.out.println("parameterized child " + x);
	}
	
}

public class MainChild {

	public static void main(String[] args) {
		Child child1=new Child();
		Child child2=new Child(10);
	}

}
