import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Мөнгө: ");
        int s = scanner.nextInt();

        System.out.println("Хүү %: ");
        int h = scanner.nextInt();

        float x = (s*h)/100;

        System.out.println("1 жилийн хүү: " + x);

        scanner.close();
    }
}
