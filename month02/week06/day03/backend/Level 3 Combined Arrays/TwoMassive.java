public class TwoMassive {
    public static void main(String[] args) {
        int[] num1 = { 3, -45, 78, -16, 0, 62, 0, 26, 0, 37 };
        int[] num2 = { 3, 45, 78, 16, 11, 62, 91, 26 };

        for (int n:num1) {
            for (int m:num2) {
                if (n==m) {
                    System.out.println(n);
                }
            }
        }
    }
}
