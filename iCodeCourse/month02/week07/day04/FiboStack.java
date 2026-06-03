public class FiboStack {
    static int fibonacci(int n) {
        if (n == 0)
            return 0; // base case
        if (n == 1)
            return 1; // base case
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
