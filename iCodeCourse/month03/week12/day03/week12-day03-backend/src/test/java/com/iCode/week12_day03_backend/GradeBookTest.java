package com.iCode.week12_day03_backend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTest {
	@Test
	void testAddGrade() {
		GradeBook g = new GradeBook();
		
		g.addGrade(100);
		g.addGrade(56);
		g.addGrade(89);
		g.addGrade(76);
		
		assertEquals(4, g.getListLength());
	}
	
	@Test
	void testAverage() {
		GradeBook g = new GradeBook();
		g.addGrade(100);
		g.addGrade(90);
		g.addGrade(80);
		
		assertEquals(90.0, g.average(), 0.01 );
	}
	
	@Test
	void testHighest() {
		GradeBook g = new GradeBook();
		g.addGrade(100);
		g.addGrade(90);
		g.addGrade(80);
		
		assertEquals(100.0, g.highest(), 0.01);
	}
	
	@Test
	void testLowest() {
		GradeBook g = new GradeBook();
		g.addGrade(100);
		g.addGrade(90);
		g.addGrade(80);
		
		assertEquals(80, g.lowest(), 0.01);
	}
	
	@Test
	void testCountAbove() {
		GradeBook g = new GradeBook();
		g.addGrade(100);
		g.addGrade(90);
		g.addGrade(80);
		
		assertEquals(2, g.countAbove(90));
	}
	
	GradeBook book;
	
	@BeforeEach
    void setup() {
        book = new GradeBook();
        book.addGrade(85);
        book.addGrade(72);
        book.addGrade(91);
        book.addGrade(68);
        book.addGrade(95);
    }
	
	@Test
	void testAverage2() {
		assertEquals(82.2, book.average());
	}
	
	@Test
	void testHighest2() {
		assertEquals(95, book.highest(), 0.01);
	}
}
