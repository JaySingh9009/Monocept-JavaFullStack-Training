package com.Oops;

public class Main {
    public static void main(String[] args) {

        CarClassExample car = new CarClassExample("BMW", "Black", 220);

        System.out.println("Car Name: " + car.getName());
        System.out.println("Car Colour: " + car.getColour());
        System.out.println("Max Speed: " + car.getMaxSpeed());
    }
}
