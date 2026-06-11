package mn.icode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {
	@Test
	void compareToTest() {
	    Product p1 = new Product("Pencil", 33.5);
	    Product p2 = new Product("Book", 30.0);

	    assertTrue(p1.compareTo(p2) < 0);
	    assertFalse(p1.compareTo(p2) > 0);
	}
}