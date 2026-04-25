package com.MaskValidator.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.MaskValidator.model.MarksValidator;

public class MarksValidatorTest {

    MarksValidator validator = new MarksValidator();


//    @Test
//    void shouldReturnTrueWhenMarksIsZero() {
//        assertTrue(validator.isValidMarks(0));
//    }
//
//    @Test
//    void shouldReturnTrueWhenMarksIsOne() {
//        assertTrue(validator.isValidMarks(1));
//    }
//
//    @Test
//    void shouldReturnTrueWhenMarksIsNinetyNine() {
//        assertTrue(validator.isValidMarks(99));
//    }
//
//    @Test
//    void shouldReturnTrueWhenMarksIsHundred() {
//        assertTrue(validator.isValidMarks(100));
//    }
//
//
//    @Test
//    void shouldReturnFalseWhenMarksIsNegative() {
//        assertFalse(validator.isValidMarks(-1));
//    }
//
//    @Test
//    void shouldReturnFalseWhenMarksExceedsHundred() {
//        assertFalse(validator.isValidMarks(101));
//    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 99, 100})
    void shouldReturnTrueForValidMarks(int marks) {
        assertTrue(validator.isValidMarks(marks));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void shouldReturnFalseForInvalidMarks(int marks) {
        assertFalse(validator.isValidMarks(marks));
    }
}
