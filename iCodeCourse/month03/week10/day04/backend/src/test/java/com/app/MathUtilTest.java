package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilTest {
    @Test
    public void testFactorial() {
        assertEquals(6, MathUtil.factorial(3));
    }

    @Test
    public void testPrime() {
        assertTrue(MathUtil.isPrime(3));
    }

    @Test
    public void testGCD() {
        assertEquals(3, MathUtil.gcd(6, 9));
    }

    @Test
    public  void testAverage() {
        assertEquals(2.5, MathUtil.average(new int[]{1,2,3,4}));
    }
}
