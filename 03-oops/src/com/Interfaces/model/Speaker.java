package com.Interfaces.model;

public class Speaker implements Controllable {

    @Override
    public void turnOn() {
        System.out.println("Speaker turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Speaker turned OFF");
    }

    @Override
    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("LowBass") ||
            mode.equalsIgnoreCase("Bass") ||
            mode.equalsIgnoreCase("HighBass")) {
            System.out.println("Speaker mode set to: " + mode);
        } else {
            System.out.println("Invalid mode for Speaker. Valid modes: LowBass, Bass, HighBass");
        }
    }
}