package mn.icode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExportableTest {
	@Test
	void toCSVTest() {
		Exportable contact = new Contact("myangaa", "myangaa123@gmail.com", "123456");
		assertEquals("myangaa, myangaa123@gmail.com, 123456", contact.toCSV());
	}
	
	@Test
	void toJSONTest() {
		Exportable contact = new Contact("myangaa", "myangaa123@gmail.com", "123456");
		assertEquals("{\"name\":\"myangaa\", \"email\":\"myangaa123@gmail.com\", \"phone\":\"123456\"}", contact.toJSON());
	}
	
	@Test
	void contactNameTest() {
		Contact contact = new Contact("myangaa", "myangaa123@gmail.com", "123456");
	    assertEquals("myangaa", contact.getName());
	}
	
	@Test
	void contactEmailTest() {
		Contact contact = new Contact("myangaa", "myangaa123@gmail.com", "123456");
	    assertEquals("myangaa123@gmail.com", contact.getEmail());
	}
	
	@Test
	void contactPhoneTest() {
		Contact contact = new Contact("myangaa", "myangaa123@gmail.com", "123456");
	    assertEquals("123456", contact.getPhone());
	}
	
	@Test
	void exportTest() {
		Exportable contact = new Contact("myangaa", "myangaa123@gmail.com", "123456");
		assertDoesNotThrow(() -> contact.export());
	}
}
