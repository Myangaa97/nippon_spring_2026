package com.iCode.week12_day03_backend;

import java.util.ArrayList;

class DuplicatesArray {

	static ArrayList<String> removeDuplicates(ArrayList<String> list) {
	    ArrayList<String> result = new ArrayList<>();

	    for(String g : list) {
	        if(!result.contains(g)) {
	            result.add(g);
	        }
	    }

	    return result;
	}
}