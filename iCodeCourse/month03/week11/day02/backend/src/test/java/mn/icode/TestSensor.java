package mn.icode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestSensor {
	
	@Test
	void testTemperatureSensor() {
		Sensor temp = new TemperatureSensor(25);
		assertEquals(25, temp.readValue());
		assertEquals("°C", temp.unit());
	}
	
	@Test
	void testReport() {
		Sensor temp = new TemperatureSensor(25);
		assertEquals("Sensor reading: 25.0 , °C", temp.report());
	}
	
	@Test
	void testIsNormal() {
		Sensor temp = new TemperatureSensor(25);
		assertTrue(temp.isNormal(20, 30));
	    assertFalse(temp.isNormal(26, 30));
	}
	
	
	
	@Test
	void testPressureSensor() {
		Sensor tempSensor = new PressureSensor(100);
		assertEquals(100, tempSensor.readValue());
		assertEquals("hPa", tempSensor.unit());
	}
	
	@Test
	void testReport1() {
		Sensor tempSensor = new PressureSensor(100);
		assertEquals("Sensor reading: 100.0 , hPa", tempSensor.report());
	}
	
	@Test
	void testIsNormal1() {
		Sensor tempSensor = new PressureSensor(100);
		assertTrue(tempSensor.isNormal(20, 130));
	    assertFalse(tempSensor.isNormal(26, 30));
	}
	
	
	
	@Test
	void testHumiditySensor() {
		Sensor tempHumidity = new HumiditySensor(40);
		assertEquals(40, tempHumidity.readValue());
		assertEquals("%", tempHumidity.unit());
	}
	
	@Test
	void testReport2() {
		Sensor tempHumidity = new HumiditySensor(40);
		assertEquals("Sensor reading: 40.0 , %", tempHumidity.report());
	}
	
	@Test
	void testIsNormal2() {
		Sensor tempHumidity = new HumiditySensor(40);
		assertTrue(tempHumidity.isNormal(20, 60));
	    assertFalse(tempHumidity.isNormal(50, 70));
	}
}
