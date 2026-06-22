package com.icode.week13_day01_backend;

import java.util.HashMap;
import java.util.Map;

public class ExeArrayHash {
	public static void main(String[] args) {
		Map<String, Double> studentScores = new HashMap<String, Double>();
		
		studentScores.put("Myangaa", 32.0);
		studentScores.put("Khishigee", 99.0);
		studentScores.put("Dorj", 82.0);
		studentScores.put("Dulmaa", 49.0);
		
		double sum = 0;
		for (double scores : studentScores.values()) {
			sum += scores;
		}
		double averageScore = sum / studentScores.size();
		
		if (averageScore > 80) {
			System.out.println("Шалгуулаа");
		}
		else {
			System.out.println("Дахин оролдоно");
		}
	}
}
