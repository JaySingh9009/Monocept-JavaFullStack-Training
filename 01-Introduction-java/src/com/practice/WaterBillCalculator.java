package com.practice;
import java.util.*;

public class WaterBillCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of units consumed: ");
        int units = sc.nextInt();

        int meterCharge = 75;
        int charge;

        if (units <= 100) {
            charge = units * 5;
        } 
        else if (units <= 250) {
            charge = units * 10;
        } 
        else {
            charge = units * 20;
        }

        int totalWaterBill = charge + meterCharge;

        System.out.println("Total Water Bill = " + totalWaterBill);

       
    }
}
