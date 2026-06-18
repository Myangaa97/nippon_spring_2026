package com.icode.week12_day04_backend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class HashMapTests {
	
	@Test
	public void testBasicPutAndGet() {
		Map<String, Integer> studentGrades = new HashMap<String, Integer>();
		
		studentGrades.put("Alice", 95);
		studentGrades.put("Bob", 82);
		
		int aliceGade = studentGrades.get("Alice");
		
		assertEquals(95, aliceGade, "Alice's grade should be 95");
		assertNull(studentGrades.get("Charlie"), "Charlie's grade is not included");
	}
	
	@Test
	public void testCheckExistence() {
		Map<String, String> capitalCities = new HashMap<String, String>();
		capitalCities.put("France", "Paris");
		capitalCities.put("Japan", "Tokyo");
		
		
		// Assertions for keys
		assertTrue(capitalCities.containsKey("Japan"));
		assertFalse(capitalCities.containsKey("Germany"));
		
		// Assertions for value
		assertTrue(capitalCities.containsValue("Paris"));
	}
	
	@Test
	public void testRemoveItem() {
		Map<Integer, String> employeeNames = new HashMap<Integer, String>();
		
		employeeNames.put(101, "Sarah");
		employeeNames.put(102, "John");
		
		// Remove employee 101
		String removeEmployee = employeeNames.remove(101);
		
		// Assertions
		assertEquals("Sarah", removeEmployee);
		assertFalse(employeeNames.containsKey(101));
		assertEquals(1, employeeNames.size());
	}
	
	@Test
	public void testUpdateExistingValue() {
		Map<String, Double> productPrice = new HashMap<String, Double>();
		productPrice.put("Coffee", 3.99);
		productPrice.put("Tea", 2.99);
		
		productPrice.put("Coffee", 3.0);
		
		assertEquals(3.0, productPrice.get("Coffee"));
		assertEquals(2, productPrice.size());
		
		assertEquals(2.99, productPrice.get("Tea"));
		assertEquals(2, productPrice.size());
		
	}
	
	@Test
	public void testSixAndClear() {
		Map<String, Integer> inventory = new HashMap<String, Integer>();
		inventory.put("Apple", 50);
		inventory.put("Oranges", 30);
		inventory.put("Bananas", 20);
		
		// Verify size
		assertEquals(3, inventory.size());
		assertFalse(inventory.isEmpty());
		
		
		// Clear the map
		inventory.clear();
		
		// Assertions after clearing
		assertEquals(0, inventory.size());
		assertTrue(inventory.isEmpty());
	}
	
	@Test
	public void testLoopOverValueToSum() {
		Map<String, Integer> shoppingCart = new HashMap<String, Integer>();
		shoppingCart.put("Apple", 2);
		shoppingCart.put("Bread", 3);
		shoppingCart.put("Milk", 4);
		
		int totalCost = 0;
		for(int n : shoppingCart.values()) {
			totalCost += n;
		}
		
		assertEquals(9, totalCost);
	}
	
	@Test
	public void testLoopOverKeysToFindMatches() {
		Map<String, String> userRoles = new HashMap<String, String>();
		userRoles.put("alice_smith", "Admin");
		userRoles.put("bob_jones", "User");
		userRoles.put("charlie_smith", "User");
		
		int smithCount = 0;
		// Loop through the keys
		
		for (String username : userRoles.keySet()) {
			if (username.endsWith("_smith")) {
				smithCount ++;
			}
		}
		
		assertEquals(2, smithCount);
	}
	
	@Test
	public void testLoopOverEnteriesToFilterData() {
		Map<String, Integer> studentScores = new HashMap<String, Integer>();
		studentScores.put("Nora", 85);
		studentScores.put("Khishigee", 92);
		studentScores.put("Myangaa", 78);
		
		String topStudent = "";
		int highScore = 0;
		
		// Loop through both keys and value at the same time
		for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
			if (entry.getValue() > highScore) {
				highScore = entry.getValue();
				topStudent = entry.getKey();
			}
		}
		
		assertEquals("Khishigee", topStudent);
		assertEquals(92, highScore);
	}
}
