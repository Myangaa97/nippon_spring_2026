public class Exe06 {
    static boolean isPositive(int n) {
        if (n > 0) return true;
        return false;
    }

    static boolean isNegative(int n) {
        if (n < 0) return true;
        return false;
    }

    static void sign(int n) {
        if (n == 0) System.out.println("Zero");
        if (n > 0) System.out.println("Positive");
        if (n < 0) System.out.println("Negative");
    }


    public static void main(String[] args) {
        System.out.println(isPositive(5));
        System.out.println(isNegative(-5));
        sign(5);
    
}
