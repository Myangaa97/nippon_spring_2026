package com.icode.week12_day02_backend;

public class ArrayExample {
	private int[] myNumbers;
	private int currentIndex;
	
	public ArrayExample() {
		myNumbers = new int[5];
		currentIndex = 0;
	}
	
	public int getLength() {
		return myNumbers.length;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	public void addNumber(int a) {
		if(currentIndex < getLength() - 1) {
			myNumbers[currentIndex] = a;
			currentIndex ++;
		}
	}
}
