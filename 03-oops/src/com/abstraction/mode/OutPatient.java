 package com.abstraction.mode;

 public class OutPatient extends Patient {

     private double consultationFee;

     public OutPatient(int patientId, String name, double consultationFee) {
         super(patientId, name);
         this.consultationFee = consultationFee;
     }

     @Override
     public double calculateCharges() {

         if (consultationFee <= 0) {
             System.out.println("Invalid consultation fee for OutPatient.");
             return 0;
         }

         double baseTreatmentCharge = 500; 
         return baseTreatmentCharge + consultationFee;
     }
 }
