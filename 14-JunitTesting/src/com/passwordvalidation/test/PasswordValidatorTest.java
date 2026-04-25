package com.passwordvalidation.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.passwordvalidation.model.PasswordValidator;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        assertTrue(validator.isValid("Password1"));
    }

//    @Test
//    void shouldReturnFalseWhenPasswordIsTooShort() {
//        assertFalse(validator.isValid("Pass1"));
//    }
//
//    @Test
//    void shouldReturnFalseWhenNoUppercasePresent() {
//        assertFalse(validator.isValid("password1"));
//    }
//
//    @Test
//    void shouldReturnFalseWhenNoDigitPresent() {
//        assertFalse(validator.isValid("Password"));
//    }



    @Test
    void shouldReturnFalseWhenPasswordIsNull() {
        assertFalse(validator.isValid(null));
    }

//    @Test
//    void shouldReturnFalseWhenPasswordIsEmpty() {
//        assertFalse(validator.isValid(""));
//    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Pass1","password1","password",""})
    void allFalsePassword(String pass) {
    	assertFalse(validator.isValid(pass));
    }
    
}
