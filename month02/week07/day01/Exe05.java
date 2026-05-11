public class Exe05 {
    // (a) — compile алдаа
    static int multiply(int a, int b) {
        return a * b;
    }

    static boolean isOdd(int n) {
        return n % 2 == 0;
    }

    static int printDouble(int n) {
        return n * 2;
    }

    // (d) — логикийн алдаа: absolute(-5) → -5 буцааж байна
    static int absolute(int n) {
        if (n > 0) return n;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(multiply(5, 6));
        System.out.println(isOdd(5));
        System.out.println(printDouble(32));
        System.out.println(absolute(56));
    }
    
}
