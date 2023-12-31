package org.example.CTCI.Chapter1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    @Test
    public void testAddAndGet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(1); // Remove "b"
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
    }

    @Test
    public void testSize() {
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1.1);
        list.add(2.2);
        assertEquals(2, list.size());
    }

    @Test
    public void testArrayGrow() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.size());
        assertEquals(14, list.get(14));
    }

    @Test
    public void testOutOfBoundsException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    // Additional tests can include checking the behavior of the list when it's empty,
    // checking the integrity of the list after several add/remove operations, etc.
}
