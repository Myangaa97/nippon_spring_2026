package com.iCode.week12_day03_backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DuplicatesArrayTest {

    @Test
    void testRemoveDuplicates_NormalCase() {

        ArrayList<String> input =
                new ArrayList<>(Arrays.asList("a", "b", "a", "c", "b", "d"));

        ArrayList<String> actual =
                DuplicatesArray.removeDuplicates(input);

        ArrayList<String> expected =
                new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveDuplicates_NoDuplicates() {

        ArrayList<String> input =
                new ArrayList<>(Arrays.asList("a", "b", "c"));

        ArrayList<String> actual =
                DuplicatesArray.removeDuplicates(input);

        ArrayList<String> expected =
                new ArrayList<>(Arrays.asList("a", "b", "c"));

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveDuplicates_AllSame() {

        ArrayList<String> input =
                new ArrayList<>(Arrays.asList("a", "a", "a", "a"));

        ArrayList<String> actual =
                DuplicatesArray.removeDuplicates(input);

        ArrayList<String> expected =
                new ArrayList<>(Arrays.asList("a"));

        assertEquals(expected, actual);
    }

    @Test
    void testRemoveDuplicates_Empty() {

        ArrayList<String> input =
                new ArrayList<>();

        ArrayList<String> actual =
                DuplicatesArray.removeDuplicates(input);

        ArrayList<String> expected =
                new ArrayList<>();

        assertEquals(expected, actual);
    }
    
    ArrayList<String> removeDuplicates(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();
        for (String item : list) {
            if (!result.contains(item)) result.add(item);
        }
        return result;
    }

    @Test
    void testRemoveDuplicates() {
        ArrayList<String> input = new ArrayList<>();
        for (String s : new String[]{"a","b","a","c","b","d"}) input.add(s);

        ArrayList<String> result = removeDuplicates(input);
        assertEquals(4, result.size());
    }

    @Test
    void testNoDuplicates() {
        ArrayList<String> input = new ArrayList<>();
        for (String s : new String[]{"x","y","z"}) input.add(s);

        assertEquals(3, removeDuplicates(input).size());
    }

    @Test
    void testEmptyList() {
        ArrayList<String> input = new ArrayList<>();
        assertEquals(0, removeDuplicates(input).size());
    }

    @Test
    void testAllSame() {
        ArrayList<String> input = new ArrayList<>();
        for (String s : new String[]{"a","a","a"}) input.add(s);

        assertEquals(1, removeDuplicates(input).size());
    }

    @Test
    void testPreservesOrder() {
        ArrayList<String> input = new ArrayList<>();
        for (String s : new String[]{"c","b","a","b","c"}) input.add(s);

        ArrayList<String> result = removeDuplicates(input);
        assertEquals("c", result.get(0));
        assertEquals("b", result.get(1));
        assertEquals("a", result.get(2));
    }
}