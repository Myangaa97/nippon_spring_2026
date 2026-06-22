package com.icode.week13_day01_backend;

import java.util.ArrayList;

public class ExeArray {
	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i < 11; i++) {
			numbers.add(i);
    	}
		System.out.println(numbers);
		
		System.out.println("Index 0f 5: " + numbers.get(5));
		
		numbers.remove(3);
		System.out.println(numbers);
	}
}
