package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    @Test
    public void testReverse() {
        assertEquals("olleH", StringUtils.reverse("Hello"));
    }

    @Test
    public void testPalindrome() { assertFalse(StringUtils.isPalindrome("Hello"));
    }

    @Test
    public void TestCountVowels() {
        assertEquals(2, StringUtils.countVowels("Hello"));
    }

    @Test
    public void testCapitalize() {
        assertEquals("HELLO", StringUtils.capitalize("Hello"));
    }
}