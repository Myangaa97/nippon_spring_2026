class Rectangle {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void area() {
        System.out.println("Talbar: " + width * height);
    }

    public void perimeter() {
        System.out.println("Perimeter: " + 2 * (width + height));
    }

    public boolean isSquare() {
        return width == height;
    }

    public void showInfo() {
        System.out.println("Rectangle: " + width + " * " + height);
        area();
        perimeter();
        System.out.println("Square: " + isSquare());
    }

}
