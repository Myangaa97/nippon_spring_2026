public class Example01 {

    // Recursion
    static int sumR(int n) {
        if (n == 0)
            return 0;
        return n + sumR(n - 1);
    }

    // Iteration
    static int sumI(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++)
            total += i;
        return total;
    }

    // Математикийн формул — O(1)!
    static int sumF(int n) {
        return n * (n + 1) / 2;
    }

    static int facI(int n) {
        int result = 1;
        for (int i = 1; i <= 3; i++) {
            result = result * i;
        }
        return result;
    }

    static int facR(int n) {
        if (n == 1)
            return 1;
        return n * facR(n - 1);
    }

    static int mystery(int n) {
        if (n == 1) {
            return 1;
        }
        return mystery(n / 2) + 1;
    }

    public static void main(String[] args) {
        System.out.println(sumR(100));
        System.out.println(sumI(100));
        System.out.println(sumF(100));
        System.out.println(facR(10));
        System.out.println(facI(3));
        System.out.println(mystery(8));
    }
}