package mn.icode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
	@Test
	void studentTest() {
		Student student = new Student("Bold", 3.5);
		assertEquals("Bold (3.5) ", student.toString());
	}
	
	@Test
	void toStringtest() {
		Student student = new Student("Bold", 3.5);
		assertEquals("Bold (3.5) ", student.toString());
	}
	
	@Test
	void compareToTest() {
	    Student s1 = new Student("Bold", 3.5);
	    Student s2 = new Student("Bat", 3.0);

	    assertTrue(s1.compareTo(s2) < 0);
	    assertFalse(s1.compareTo(s2) > 0);
	}
}