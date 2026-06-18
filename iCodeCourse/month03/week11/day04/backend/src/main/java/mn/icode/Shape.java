package mn.icode;

public interface Shape {
	double area();
	double perimeter();
	
	default String describe() {
		return String.format(
				"%s: area=%.2f, perimeter=%.2f",
		        getClass().getSimpleName(),
		        area(),
		        perimeter()
		    );
	}
	
	default boolean isLargerThan(Shape other) {
		return area() > other.area();
	}
}

class Circle implements Shape {
	double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
	
}

class Rectangle implements Shape {
	double width;
	double height;
	
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return (width + height) * 2;
	}
}

class Triangle implements Shape {
	double a;
	double b;
	double c;
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double area() {
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	public double perimeter() {
		return a + b + c;
	}
}