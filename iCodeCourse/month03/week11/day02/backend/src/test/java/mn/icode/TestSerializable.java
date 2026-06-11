package mn.icode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSerializable {
	@Test
    void testUserSerialize() {
        User user = new User("Bold", "bold@mail.com");
        assertEquals("User{name=Bold, email=bold@mail.com}", user.serialize()
        );
    }
	
	@Test
    void configSerializeTest() {
        Config config = new Config("color", "black");
        assertEquals("Config{key=color, value=black}",
            config.serialize()
        );
    }

    @Test
    void defaultPrintDoesNotThrow() {
        User user = new User("Bob", "bob@mail.com");

        assertDoesNotThrow(() -> {user.print();
        });
    }

    @Test
    void interfacePolymorphismTest() {
        Serializable s1 = new User("Tom", "tom@mail.com");
        Serializable s2 = new Config("lang", "en");

        assertTrue(s1.serialize().contains("User"));
        assertTrue(s2.serialize().contains("Config"));
    }
}
