package com.babylonhealth.recruitment;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JLinkedListTest {
    private static final int VALUE_1 = 1, VALUE_2 = 2, VALUE_3 = 3;

    private static JLinkedList newList(int value) {
        return new JValueNode(VALUE_1, JNullNode.INSTANCE);
    }
    private static JLinkedList newList(int value1, int value2) {
        return new JValueNode(value1, new JValueNode(value2, JNullNode.INSTANCE));
    }

    @Test
    void testListWithOneElement() {
        JLinkedList list = newList(VALUE_1);
        assertEquals(VALUE_1, list.value());
        assertSame(JNullNode.INSTANCE, list.next());
        assertEquals(1, list.length());
        assertFalse(list.hasCycle());
    }

    @Test
    void testListWithTwoElements() {
        JLinkedList list = newList(VALUE_1, VALUE_2);
        assertEquals(VALUE_1, list.value());
        assertFalse(list.hasCycle());
        assertEquals(2, list.length());

        JLinkedList secondList = list.next();
        assertEquals(VALUE_2, secondList.value());
        assertSame(JNullNode.INSTANCE, secondList.next());
        assertEquals(1, secondList.length());
        assertFalse(secondList.hasCycle());
    }

    @Test
    void testSetNext() {
        JLinkedList list1 = newList(VALUE_1);
        JLinkedList list2 = newList(VALUE_2);
        list1.setNext(list2);

        assertEquals(2, list1.length());
        assertEquals(VALUE_1, list1.value());
        assertSame(list2, list1.next());
        assertFalse(list1.hasCycle());
    }

    @Test
    void testSingleElementCycle() {
        JLinkedList list = newList(VALUE_1);
        list.setNext(list);
        assertTrue(list.hasCycle());
        assertThrows(JLinkedList.CyclicalException.class, list::length);
    }

    @Test
    void testCycle() {
        JLinkedList list1 = newList(VALUE_1);
        JLinkedList list2 = newList(VALUE_2);
        JLinkedList list3 = newList(VALUE_3);

        list1.setNext(list2);
        list2.setNext(list3);
        list3.setNext(list1);

        assertTrue(list1.hasCycle());
        assertTrue(list2.hasCycle());
        assertTrue(list3.hasCycle());

        assertThrows(JLinkedList.CyclicalException.class, list1::length);
        assertThrows(JLinkedList.CyclicalException.class, list2::length);
        assertThrows(JLinkedList.CyclicalException.class, list3::length);
    }
}