public class Base1 {
    static int countDown(int n) {
        if (n == 0) {
            System.out.println("Boom!");
            return 0;
        }
        System.out.println(n);
        return countDown(n - 1);
    }

    static int sumDigits(int n) {
        if (n < 10)
            return n;
        return (n % 10) + sumDigits(n / 10);
    }

    static int power(int x, int n) {
        if (n == 0)
            return 1;
        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        countDown(3);
        System.out.println(sumDigits(15));
        System.out.println(power(2, 3));
    }
}
