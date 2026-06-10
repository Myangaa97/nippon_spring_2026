package mn.icode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGreetable {
	@Test
	void testEnglish() {
		Greetable eng = new English("Hello");
		assertEquals("Hello", eng.greet());
	}
	
	@Test
	void testEngGreetLoud() {
		Greetable loud = new English("Hello");
		assertEquals("HELLO", loud.greetLoud().toUpperCase());
	}
	
	
	@Test
	void testJapanese() {
		Greetable jp = new Japanese("Konnichiwa");
		assertEquals("Konnichiwa", jp.greet());
	}
	
	
	@Test
	void testJpGreetLoud() {
		Greetable loud = new Japanese("Konnichiwa");
		assertEquals("KONNICHIWA", loud.greetLoud().toUpperCase());
	}
}
