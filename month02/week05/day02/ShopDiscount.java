import java.util.Scanner;

public class ShopDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Нийт дүн (₮): ");
        int total = scanner.nextInt();
        double x;

        if (total < 100000) {
            System.out.println("Хөнгөлөлт 0%: " + total);
        } else if (total < 100000 && total > 499999) {
            x = total * 5 / 100;
            System.out.println("Хөнгөлөлт 5%: " + (total - x));

        } else if (total < 500000 && total > 999999) {
            x = total * 10 / 100;
            System.out.println("Хөнгөлөлт 10%: " + (total - x));
        } else {
            x = total * 15 / 100;
            System.out.println("Хөнгөлөлт 15%: " + (total - x));
        }
        scanner.close();
    }
}
