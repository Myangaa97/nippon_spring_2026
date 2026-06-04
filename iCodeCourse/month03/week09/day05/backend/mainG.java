public class mainG {
    public static void main(String[] args) {
        int a = 6, b = 9;
        for (int i = a + b; i > 1;) {
            if (a / i == b / i) {
                System.out.println(i);
            }
            i--;
            break;
        }
    }
}