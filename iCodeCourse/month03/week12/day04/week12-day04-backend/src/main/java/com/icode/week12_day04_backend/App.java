package com.icode.week12_day04_backend;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
    	
    	ArrayList<Integer> numbers = new ArrayList<>();
    			
    	numbers.add(1);
    	numbers.add(2);
    	numbers.add(3);
    	numbers.add(4);
    	numbers.add(5);
    	
        numbers.set(0, -100);
        numbers.add(2,10);
        numbers.remove(numbers.size()-1);
        
        for(int n : numbers) {
    		System.out.println(n);
    	}
    }
}