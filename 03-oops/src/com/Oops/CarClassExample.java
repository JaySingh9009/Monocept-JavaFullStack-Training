package com.Oops;

public class CarClassExample {
	String name;
	String colour;
	int MaxSpeed;
	public CarClassExample(String name, String colour, int maxSpeed) {
		
		this.name = name;
		this.colour = colour;
		MaxSpeed = maxSpeed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getMaxSpeed() {
		return MaxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		MaxSpeed = maxSpeed;
	}
	
	
	
}
