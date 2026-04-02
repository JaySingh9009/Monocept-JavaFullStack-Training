package com.digitalLoan.test;

import java.util.Scanner;

import com.digitalLoan.service.LoanServiceManager;

public class LoanProcessingSystem {

    public static void main(String[] args) {

        LoanServiceManager manager = new LoanServiceManager();
        manager.startSystem();
    }
}