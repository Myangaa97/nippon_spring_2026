abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract double area();

    abstract double perimeter();

    void describe() {
        System.out.printf("%s %s: area=%.2f, perimeter=%.2f%n", color, getClass().getSimpleName(), area(), perimeter());
    }

    boolean isBiggerThan(Shape other) {
        return this.area() > other.area();
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius + radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double perimeter() {
        return 2 * (width + height);
    }
}

class Triangle extends Shape {
    double a, b, c;

    Triangle(String color, double a, double b, double c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double area() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double perimeter() {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("red", 5),
                new Rectangle("blue", 4, 6),
                new Triangle("green", 3, 4, 5)
        };

        for (Shape s : shapes)
            s.describe();

        System.out.println("\nCircle bigger than Rectangle? " + shapes[0].isBiggerThan(shapes[1]));
    }
}