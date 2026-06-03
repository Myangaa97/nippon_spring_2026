import java.util.Scanner;

public class MoneyBreakdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Мөнгө (₮): ");
        int a = scanner.nextInt();

        int b = a / 1000;
        int c = a % 1000 / 500;
        int d = a % 1000 % 500 / 100;
        int e = a % 1000 % 500 % 100 / 50;
        
        System.out.println("1000 ₮: " + b);
        System.out.println(" 500 ₮: " + c);
        System.out.println(" 100 ₮: " + d);
        System.out.println("  50 ₮: " + e);

        scanner.close();
    }
}
