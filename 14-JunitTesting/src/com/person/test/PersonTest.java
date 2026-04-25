package com.person.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.person.model.Person;

public class PersonTest {

    @Test
    void testPersonProperties() {

        Person person = new Person("Sherlock", 25, "ACTIVE");

        assertAll("Person Properties",
                () -> assertEquals("Sherlock", person.getName()),
                () -> assertEquals(25, person.getAge()),
                () -> assertEquals("ACTIVE", person.getStatus())
        );
    }
}
