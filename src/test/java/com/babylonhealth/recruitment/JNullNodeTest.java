package com.babylonhealth.recruitment;


import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JNullNodeTest {

    @Test
    void testValue() {
        assertThrows(NoSuchElementException.class, JNullNode.INSTANCE::value);
    }

    @Test
    void testNext() {
        assertThrows(NoSuchElementException.class, JNullNode.INSTANCE::next);
    }

    @Test
    void testSetNext() {
        assertThrows(NoSuchElementException.class, () -> JNullNode.INSTANCE.setNext(JNullNode.INSTANCE));
    }

    @Test
    void testLength() {
        assertEquals(0, JNullNode.INSTANCE.length());
    }

    @Test
    void testHasCycle() {
        assertFalse(JNullNode.INSTANCE.hasCycle());
    }
}