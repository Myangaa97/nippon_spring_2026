package com.icode.week12_day02_backend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrayListExampleTest {
	@Test
	void testArrayList() {
		ArrayListExample  a = new ArrayListExample();
		assertEquals(a.getListLength(), 0);
		
		a.addFruits();
		assertEquals(a.getListLength(), 6);
		
		a.addFruits();
		assertEquals(a.getListLength(), 12);
		
		assertEquals(a.getFruitsByIndex(0), "Melon");
		assertEquals(a.getFruitsByIndex(1), "Melon");
		assertEquals(a.getFruitsByIndex(2), "Apple");
		
		assertTrue(a.isFruitExists("Apple"));
		assertFalse(a.isFruitExists("Mango"));
		
		assertFalse(a.isListEmpty());
		
		a.changeFruit("Watermelon", 0);
		assertTrue(a.isFruitExists("Watermelon"));
		
		a.deleteFruitByIndex(0);
		assertEquals(a.getListLength(), 11);
	}
}
