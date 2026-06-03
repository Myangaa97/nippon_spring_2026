import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Тоо оруулна уу: ");
        int n = sc.nextInt();
        int sum = 0;
        while (n>0) {
            sum += n % 10;
            n /= 10;
        }

        System.out.println("Цифрүүдийн нийлбэр: " + sum);
        sc.close();
    }
}
