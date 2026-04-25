package com.stringutility.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.stringutility.model.StringUtility;

public class StringUtilityTest {

    StringUtility util = new StringUtility();

    @Test
    void testIsEmptyWithNull() {
        assertTrue(util.isEmpty(null));
    }

//    @Test
//    void testIsEmptyWithEmptyString() {
//        assertTrue(util.isEmpty(""));
//    }
//
//    @Test
//    void testIsEmptyWithWhitespace() {
//        assertFalse(util.isEmpty(" "));
//    }
//
//    @Test
//    void testIsEmptyWithNormalString() {
//        assertFalse(util.isEmpty("Hello"));
//    }

    @ParameterizedTest
    @CsvSource({
            "'', true",
            "' ', false",
            "Hello, false"
    })
    void shouldCheckIsEmpty(String input, boolean expected) {
        assertEquals(expected, util.isEmpty(input));
    }
  
//    @Test
//    void testToUpperCaseNormal() {
//        assertEquals("HELLO", util.toUpperCase("hello"));
//    }

    @Test
    void testToUpperCaseNull() {
        assertNull(util.toUpperCase(null));
    }
//
//    @Test
//    void testToUpperCaseEmpty() {
//        assertEquals("", util.toUpperCase(""));
//    }
//
//    @Test
//    void testToUpperCaseWhitespace() {
//        assertEquals(" ", util.toUpperCase(" "));
//    }
    
    @ParameterizedTest
    @CsvSource({
            "hello, HELLO",
            "'', ''",
            "' ', ' '"
    })
    void shouldConvertToUpperCase(String input, String expected) {
        assertEquals(expected, util.toUpperCase(input));
    }
//
//    @Test
//    void testGetLengthNormal() {
//        assertEquals(5, util.getLength("Hello"));
//    }

    @Test
    void testGetLengthNull() {
        assertNull(util.getLength(null));
    }

//    @Test
//    void testGetLengthEmpty() {
//        assertEquals(0, util.getLength(""));
//    }
//
//    @Test
//    void testGetLengthWhitespace() {
//        assertEquals(1, util.getLength(" "));
//    }
//
//    @Test
//    void testGetLengthNotNull() {
//        assertNotNull(util.getLength("Test"));
//    }
    
    @ParameterizedTest
    @CsvSource({
            "Hello, 5",
            "'', 0",
            "' ', 1"
    })
    void shouldReturnLength(String input, int expected) {
        assertEquals(expected, util.getLength(input));
    }
}
