public class Exe01 {
    static void greet(String name) {
        System.out.println("Hello, " + "!");
    }

    static int max(int a, int b) {
        if (a > b) return a;
        return b;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static double circleArea(int r) {
        return Math.PI * r * r;
    }
    public static void main(String[] args) {
        greet("myangaa");
        System.out.println(max(5, 6));
        System.out.println(isEven(4));
        System.out.println(circleArea(5));
    }
}
