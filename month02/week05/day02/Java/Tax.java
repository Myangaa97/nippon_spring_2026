import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Жилийн орлого (₮): ");
        long income = scanner.nextLong();
        double x;

        if (income > 0 && income < 10000000) {
            x = income * 10 / 100;
            System.out.printf("Татварын хувь 10 = %.2f", x);

        } else if (income > 10000000 && income < 50000000) {
            x = income * 15 / 100;
            System.out.printf("Татварын хувь 15 = %.2f", x);

        } else {
            x = income * 20 / 100;
            System.out.printf("Татварын хувь 20 = %.2f", x);
        }
        scanner.close();
    }
}
