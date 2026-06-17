package com.icode.week12_day02_backend;

import java.util.ArrayList;

public class ArrayListExample {
	
	private ArrayList<String> fruits = new ArrayList<String>();
	
	public void addFruits() {
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Kiwi");
		fruits.add("Orange");
		fruits.add("Grapes");
		fruits.add(0, "Melon");
	}
	
	public int getListLength() {
		return fruits.size();
	}

	public String getFruitsByIndex(int index){
		return fruits.get(index);
	}
	
	public boolean isFruitExists(String fruitName) {
		return fruits.contains(fruitName);
	}
	
	public boolean isListEmpty() {
		return fruits.isEmpty();
	}
	
	public void changeFruit(String newFruit, int index) {
		fruits.set(index, newFruit);
	}
	
	public void deleteFruitByIndex(int index) {
		fruits.remove(index);
	}
}
