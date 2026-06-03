import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Суурь тоо: "); int base = sc.nextInt();
        System.out.print("Зэрэг: ");     int exp  = sc.nextInt();
        int result = 1;
        for (int i=1; i<=exp; i++) {
            result = result * base;
        }
        System.out.println(base + "^" + exp + " = " + result);
        sc.close();
    }
}
