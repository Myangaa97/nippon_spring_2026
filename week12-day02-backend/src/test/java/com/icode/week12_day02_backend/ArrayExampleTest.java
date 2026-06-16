package com.icode.week12_day02_backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrayExampleTest {
	@Test
	void testArrayAdd() {
		ArrayExample a = new ArrayExample();
		
		assertEquals(a.getLength(), 5);
		assertEquals(a.getCurrentIndex(), 0);
		
		a.addNumber(5);
		assertEquals(a.getLength(), 5);
		assertEquals(a.getCurrentIndex(), 1);
		
		a.addNumber(5);
		assertEquals(a.getLength(), 5);
		assertEquals(a.getCurrentIndex(), 2);
		
		a.addNumber(5);
		assertEquals(a.getLength(), 5);
		assertEquals(a.getCurrentIndex(), 3);
		
		
		a.addNumber(5);
		assertEquals(a.getLength(), 5);
		assertEquals(a.getCurrentIndex(), 4);
	}
}
