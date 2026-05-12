public class MathHelper {
    static int sum (int a, int b){
        return a + b;
    }

    static int product (int a, int b) {
        return a * b;
    }

    static double average(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    static int max(int a, int b) {
        if(a > b) return a;
        return b;
    }

    static int min (int a, int b) {
        if (a < b) return a;
        return b;
    }

    static int absolute (int a) {
        if (a < 0) return -a;
        return a;
    }
    public static void main(String[] args) {
        System.out.println("Sum: " + sum(3, 5));
        System.out.println("Product: " + product(4, 6));
        System.out.println("Average: " + average(10, 20, 30));
        System.out.println("Max: " + max(7, 3));
        System.out.println("Min: " + min(7, 3));
        System.out.println("Absolute: " + absolute(-15));
    }
}