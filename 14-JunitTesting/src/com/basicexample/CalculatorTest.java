package com.basicexample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.add(2, 3));
    }
}