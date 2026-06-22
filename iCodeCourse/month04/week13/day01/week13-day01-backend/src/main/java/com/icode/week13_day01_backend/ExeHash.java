package com.icode.week13_day01_backend;

import java.util.HashMap;
import java.util.Map;

public class ExeHash {
	public static void main(String[] args) {
		Map<String, Double> student = new HashMap<String, Double>();
		
		student.put("Myangaa", 32.0);
		student.put("Khishigee", 99.0);
		student.put("Dorj", 12.0);
		student.put("Dulmaa", 19.0);
		
		System.out.println("20-оос дээш:");
        for (String name : student.keySet()) {
            if (student.get(name) > 20) {
                System.out.println(name + ": " + student.get(name));
            }
        }
	}
}
