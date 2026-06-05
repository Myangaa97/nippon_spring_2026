package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void testCircleArea() {
        Circle circle = new Circle(5);
        assertEquals(Math.PI * 25, circle.area(), 0.001);
    }

    @Test
    void testCirclePerimeter() {
        Circle circle = new Circle(5);
        assertEquals(2 * Math.PI * 5, circle.perimeter(), 0.001);
    }

    @Test
    void testSquareArea() {
        Square square = new Square(4);
        assertEquals(16, square.area(), 0.001);
    }

    @Test
    void testSquarePerimeter() {
        Square square = new Square(4);
        assertEquals(16, square.perimeter(), 0.001);
    }

    @Test
    void testRectangleArea() {
        Rectangle rect = new Rectangle(3, 4);
        assertEquals(12, rect.area(), 0.001);
    }

    @Test
    void testRectanglePerimeter() {
        Rectangle rect = new Rectangle(3, 4);
        assertEquals(14, rect.perimeter(), 0.001);
    }

    @Test
    void testLargerThan() {
        Circle c1 = new Circle(3);
        Circle c2 = new Circle(4);

        assertTrue(c2.area() > c1.area());
        assertFalse(c1.area() > c2.area());
    }

    @Test
    void testDescription() {
        Square square = new Square(2);
        String result = square.description();

        assertTrue(result.contains("Square"));
        assertTrue(result.contains("Area: 4.0"));
        assertTrue(result.contains("Perimeter: 8.0"));
    }
}