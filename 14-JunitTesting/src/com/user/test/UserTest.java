package com.user.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.user.model.User;

public class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("Sherlock", 25);
        System.out.println("Setup done");
    }

    @AfterEach
    void tearDown() {
        user = null;
        System.out.println("Cleanup done");
    }

    @Test
    void testValidUser() {
        assertNotNull(user);
        assertEquals("Sherlock", user.getName());
        assertEquals(25, user.getAge());
    }

    @Test
    void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User(null, 25);
        });
    }

    @Test
    void testInvalidAgeNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("John", -5);
        });
    }

    @Test
    void testInvalidAgeTooHigh() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("John", 150);
        });
    }
}
