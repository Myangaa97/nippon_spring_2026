package mn.icode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSensor {
	
	@Test
	void testTemperatureSensor() {
		TemperatureSensor temp = new TemperatureSensor(14);
		temp.celsius(25);
		assertEquals(25, temp.celsius);
	}
}
