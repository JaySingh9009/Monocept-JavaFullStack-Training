package com.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.calculator.model.Calculator;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    Calculator calc = new Calculator();

//    @Test
//    void testAddPositive() {
//        assertEquals(10, calc.add(5, 5));
//    }
//
//    @Test
//    void testAddNegative() {
//        assertEquals(-6, calc.add(-3, -3));
//    }
//
//    @Test
//    void testAddMixed() {
//        assertEquals(2, calc.add(5, -3));
//    }
//
//    @Test
//    void testAddZero() {
//        assertEquals(5, calc.add(5, 0));
//    }
//
//    @Test
//    void testAddNotEquals() {
//        assertNotEquals(9, calc.add(5, 5));
   
//    }
    
    @ParameterizedTest
    @Order(1)
    @CsvSource({
    	"1 , 2, 3",
    	"-1,-2, -3",
    	"-1, 2, 1"
    	
    })
    void additionOfAllKindValues(int a,int b, int c) {
    	assertEquals(c,calc.add(a, b));
    }

//    @Test
//    void testSubtractPositive() {
//        assertEquals(2, calc.subtract(5, 3));
//    }
//
//    @Test
//    void testSubtractNegative() {
//        assertEquals(0, calc.subtract(-3, -3));
//    }
//
//    @Test
//    void testSubtractMixed() {
//        assertEquals(8, calc.subtract(5, -3));
//    }
//
//    @Test
//    void testSubtractZero() {
//        assertEquals(5, calc.subtract(5, 0));
//    }
//
//    @Test
//    void testSubtractNotEquals() {
//        assertNotEquals(1, calc.subtract(5, 3));
//    }
    
    @ParameterizedTest
    @Order(2)
    @CsvSource({
    	"1 , 2, -1",
    	"2, 1, 1",
    	"-3, -3, 0 "
    	
    })
    void substractionUsingAllInput(int a , int b,int c) {
    	assertEquals(c,calc.subtract(a, b));
    }

//    @Test
//    void testMultiplyPositive() {
//        assertEquals(15, calc.multiply(5, 3));
//    }
//
//    @Test
//    void testMultiplyNegative() {
//        assertEquals(9, calc.multiply(-3, -3));
//    }
//
//    @Test
//    void testMultiplyMixed() {
//        assertEquals(-15, calc.multiply(5, -3));
//    }
//
//    @Test
//    void testMultiplyZero() {
//        assertEquals(0, calc.multiply(5, 0));
//    }
//
//    @Test
//    void testMultiplyNotEquals() {
//        assertNotEquals(10, calc.multiply(5, 3));
//    }
    
    
    @ParameterizedTest
    @Order(3)
    @CsvSource({
    	"1 , 2, 2",
    	"-2, -1, 2",
    	"-3, 3, -9 "
    	
    })
    void multiplyUsingAllInput(int a , int b,int c) {
    	assertEquals(c,calc.multiply(a, b));
    }
//
//    @Test
//    void testDividePositive() {
//        assertEquals(2, calc.divide(6, 3));
//    }
//
//    @Test
//    void testDivideNegative() {
//        assertEquals(1, calc.divide(-3, -3));
//    }
//
//    @Test
//    void testDivideMixed() {
//        assertEquals(-2, calc.divide(6, -3));
//    }
//
//    @Test
//    void testDivideZeroNumerator() {
//        assertEquals(0, calc.divide(0, 5));
//    }
//
//    @Test
//    void testDivideNotEquals() {
//        assertNotEquals(3, calc.divide(6, 3));
//    }
    
    @ParameterizedTest
    @Order(4)
    @CsvSource({
    	"2 , 2, 1",
    	"-2, -1, 2",
    	"-3, 3, -1 "
    	
    })
    void divideUsingAllInput(int a , int b,int c) {
    	assertEquals(c,calc.divide(a, b));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }
}