package com.icode.week13_day01_backend;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ExeArrayTests {
	@Test
	void testExeArrayTotalSum() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
    	}
		
		numbers.add(45);
		
		double sum = 0;
		for(double num : numbers) {
			sum += num;
		}
		
		assertEquals(100.0, sum);
		assertEquals(11, numbers.size());
	}
	
	@Test
	void testExeArrayCheckIndexValue() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
    	}
		
		assertEquals(6, numbers.get(5));
	}
	
	@Test
	void testExeArrayRemove() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
    	}
		
		numbers.remove(2);
		assertEquals(9, numbers.size());
	}
	
	@Test
	void testExeArrayUpdate() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
    	}
		
		numbers.set(3, 100);
		
		assertEquals(100, numbers.get(3));
	}
}
