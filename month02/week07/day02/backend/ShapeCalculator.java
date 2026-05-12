public class ShapeCalculator {

    static double circleArea(int r) {
        return Math.PI * r * r;
    }

    static double circlePerimeter(int r) {
        return 2 * Math.PI * r;
    }

    static double rectArea(int a, int b) {
        return a * b;
    }

    static double rectPerimeter(int a, int b) {
        return (a + b) * 2;
    }

    static double triangleArea(int b, int h) {
        return (b * h) / 2;
    }

    public static void main(String[] args) {
        System.out.println("=== Хэлбэрийн Тооцоолуур ===");
        System.out.println("Тойрог (r=5): ");
        System.out.printf("Талбай: %.2f\n", circleArea(5));
        System.out.printf("Периметр: %.2f\n", circlePerimeter(5));
        System.out.println("Тэгш өнцөгт (4×6): ");
        System.out.println("Талбай: " + rectArea(4, 6));
        System.out.println("Периметр: " + rectPerimeter(4, 6));
        System.out.println("Гурвалжин (b=8, h=5): ");
        System.out.println("Талбай: " + triangleArea(8, 5));
    }
}
