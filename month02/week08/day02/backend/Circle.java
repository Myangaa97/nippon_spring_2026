public class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public boolean isLarger(Circle c) {
        return this.area() > c.area();
    }

    public void showInfo() {
        System.out.printf("%.2f\n", area());
        System.out.printf("%.2f\n", circumference());
    }
}
