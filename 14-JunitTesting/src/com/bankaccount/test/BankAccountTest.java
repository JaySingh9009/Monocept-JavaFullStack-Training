package com.bankaccount.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bankaccount.model.BankAccount;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000); 
    }

    @AfterEach
    void tearDown() {
        account = null;
    }

    @Test
    void testDepositValid() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdrawValid() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testMultipleOperations() {
        account.deposit(200);   
        account.withdraw(500);  
        assertEquals(700, account.getBalance());
    }


    @Test
    void testDepositInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
    }

    @Test
    void testWithdrawInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100);
        });
    }

    @Test
    void testWithdrawInsufficientBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }



    @Test
    void testBalanceUnchangedAfterFailedTransaction() {
        try {
            account.withdraw(2000); 
        } catch (Exception e) {
            // ignore
        }
        assertEquals(1000, account.getBalance());
    }
}
