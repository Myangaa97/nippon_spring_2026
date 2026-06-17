package com.iCode.week12_day03_backend;

import java.util.ArrayList;

class GradeBook {
	private ArrayList<Integer> grades = new ArrayList<>();
	
	public void addGrade(int grade) {
		grades.add(grade);
	}
	
	public int getListLength() {
		return grades.size();
	}

	double average() {
		double sum = 0;
		for(int g : grades) {
			sum += g;
		}
		return sum / grades.size();
	}

	int highest() {
		int max = grades.get(0);
		for(int g : grades) {
			if (max < g) {
				max = g;
			}
		}
		return max;
	}

	int lowest() {
		int min = grades.get(0);
		for(int g : grades) {
			if (min > g) {
				min = g;
			}
		}
		return min;
	}

	int countAbove(int threshold) {
		int count = 0;
		for(int g : grades) {
			if (g >= threshold) {
				count++;
			}
		}
		return count;
	}

	void showAll() {
		
	}
}
