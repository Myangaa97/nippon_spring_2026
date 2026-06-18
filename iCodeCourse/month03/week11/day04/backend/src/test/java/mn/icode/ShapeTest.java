package mn.icode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShapeTest {
	@Test
	void testCircleArea() {
		Shape circle = new Circle(5);
		assertEquals(78.53, circle.area(), 0.01);
	}
	
	@Test
	void testCirclePerimeter() {
		Shape circle = new Circle(5);
		assertEquals(31.42, circle.perimeter(), 0.01);
	}
	
	@Test
	void testRectangleArea() {
		Shape rectangle = new Rectangle(4, 6);
		assertEquals(24.0, rectangle.area(), 0.01);
	}
	
	@Test
	void testRectanglePerimeter() {
		Shape rectangle = new Rectangle(4, 6);
		assertEquals(20.0, rectangle.perimeter(), 0.01);
	}
	
	@Test
	void testTriangleArea() {
		Shape triangle = new Triangle(3, 4, 5);
		assertEquals(6.0, triangle.area(), 0.01);
	}
	
	@Test
	void testTrianglePerimeter() {
		Shape triangle = new Triangle(3, 4, 5);
		assertEquals(12.0, triangle.perimeter(), 0.01);
	}
	
	@Test
	void testIsLargerThan() {
		Shape s1 = new Circle(5);
		Shape s2 = new Rectangle(4, 6);
		assertTrue(s1.isLargerThan(s2));
		assertFalse(s2.isLargerThan(s1));
	}
	
	@Test
	void testDescribeContainsClassName() {
		Shape c = new Circle(5);
		Shape r = new Rectangle(4, 6);
		Shape t = new Triangle(3, 4, 5);
		assertEquals("Circle: area=78.54, perimeter=31.42", c.describe());
		assertEquals("Rectangle: area=24.00, perimeter=20.00", r.describe());
		assertEquals("Triangle: area=6.00, perimeter=12.00", t.describe());
	}
	
	@Test
	void testZeroRadius() {
		Shape circle = new Circle(0);
		assertEquals(0.0, circle.area(), 0.01);
		assertEquals(0.0, circle.perimeter(), 0.01);
	}
	
	@Test
    void testPolymorphicArray() {
        Shape[] shapes = {
            new Circle(2),
            new Rectangle(3, 4),
            new Triangle(5, 5, 5)
        };
        for (Shape s : shapes) {
            assertTrue(s.area() > 0);
            assertTrue(s.perimeter() > 0);
        }
    }
}